package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.validator.postCondition.PostConditionResult
import edu.austral.dissis.chess.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.ITurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.WinCondition

class GameState(private val boards : List<IBoard>,
                private val winCondition: WinCondition,
                private val turnManager: ITurnValidator,
                private val preConditions: List<Validator>,
                private val postConditions: List<PostConditionValidator>) : IGameState {

    override fun getBoards(): List<IBoard> {
        return boards
    }

    override fun getCurrentBoard(): IBoard {
        return boards.last()
    }

    override fun movePiece(movement: Movement): IGameState {
        //valida el turno
        val turnResponse : ValidatorResponse = getTurnManager().validateTurn(movement, this)
        if ( turnResponse is ValidatorResponse.ValidatorResultInvalid) {
            return InvalidMoveGameState(this.getBoards(),
                                        this.getWinCondition(),
                                        this.getTurnManager(),
                                        this.getListPreConditions(),
                                        this.getListPostConditions(),
                                        turnResponse.message)
        }
        //valida las precondiciones
        val preConditionResponse : ValidatorResponse = validatePreConditions(movement)
        if (preConditionResponse is ValidatorResponse.ValidatorResultInvalid) {
            return InvalidMoveGameState(this.getBoards(),
                                        this.getWinCondition(),
                                        this.getTurnManager(),
                                        this.getListPreConditions(),
                                        this.getListPostConditions(),
                                        preConditionResponse.message)
        }
        //valida los movimientos
        val pieceMoveResponse : ValidatorResponse = validatePieceMove(movement)
        if (pieceMoveResponse is ValidatorResponse.ValidatorResultInvalid) {
            return InvalidMoveGameState(this.getBoards(),
                                        this.getWinCondition(),
                                        this.getTurnManager(),
                                        this.getListPreConditions(),
                                        this.getListPostConditions(),
                                        pieceMoveResponse.message)
        }
        //valida las postCondiciones
        val boardAux: IBoard = this.getCurrentBoard().update(movement)

        val postConditionResponse : PostConditionResult = validatePostConditions(boardAux)
        val boardAfterPostConditions = if( postConditionResponse is PostConditionResult.ResultValid) postConditionResponse.board else boardAux

        val gameAuxBoards = this.getBoards().toMutableList()
        gameAuxBoards.add(boardAfterPostConditions)

        val gameAux = GameState(gameAuxBoards,
                                    this.getWinCondition(),
                                    this.getTurnManager(),
                                    this.getListPreConditions(),
                                    this.getListPostConditions())
        //valida las winConditions
        if (getWinCondition().isWin(gameAux)) {
            return FinishGameState(gameAux.getBoards(),
                                    gameAux.getWinCondition(),
                                    gameAux.getTurnManager(),
                                    gameAux.getListPreConditions(),
                                    gameAux.getListPostConditions())
        }

        val piece : Piece = this.getCurrentBoard().getPieceByPosition(movement.from)!!
        piece.incrementMoveCounter()

        return GameState(gameAuxBoards,
                            this.getWinCondition(),
                            this.getTurnManager().nextTurn(),
                            this.getListPreConditions(),
                            this.getListPostConditions())
    }



    override fun getTurnManager(): ITurnValidator {
        return turnManager
    }

    override fun getListPreConditions(): List<Validator> {
        return preConditions
    }

    override fun getListPostConditions(): List<PostConditionValidator> {
        return postConditions
    }

    override fun getWinCondition(): WinCondition {
        return winCondition
    }

    override fun getCurrentTurn(): Color {
        return turnManager.getTurn()
    }

    private fun validatePreConditions(movement: Movement): ValidatorResponse {
        for (preCondition in getListPreConditions()) {
            when (val preConditionResponse : ValidatorResponse = preCondition.validate(movement, this)) {
                is ValidatorResponse.ValidatorResultInvalid -> return preConditionResponse
                is ValidatorResponse.ValidatorResultValid -> continue
            }
        }
        return ValidatorResponse.ValidatorResultValid("Se cumplen todas las precondiciones")
    }

    private fun validatePieceMove(movement: Movement): ValidatorResponse {
        val piece = getCurrentBoard().getPieceByPosition(movement.from) ?: return ValidatorResponse.ValidatorResultInvalid("No hay una pieza en esta posicion para mover")
        return piece.validateMove(movement, this)
    }

    private fun validatePostConditions( board : IBoard): PostConditionResult {
        var boardAux : IBoard = board
        for (postCondition in getListPostConditions()){
            when (val postConditionResponse : PostConditionResult = postCondition.validate( this, boardAux)) {
                is PostConditionResult.ResultValid -> boardAux = postConditionResponse.board
                is PostConditionResult.ResultInvalid -> continue
            }
        }
        return PostConditionResult.ResultValid(boardAux)
    }

}