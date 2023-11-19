package edu.austral.dissis.chess.game

import edu.austral.dissis.chess.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.common.ITurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.WinCondition

class GameState(private val boards : List<IBoard>,
                private val winCondition: WinCondition,
                private val turnManager: ITurnValidator,
                private val preConditions: List<Validator>,
                private val postConditions: List<Validator>) : IGameState {

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
        val postConditionResponse : ValidatorResponse = validatePostConditions(movement)
        if (postConditionResponse is ValidatorResponse.ValidatorResultInvalid) {
            return InvalidMoveGameState(this.getBoards(),
                                        this.getWinCondition(),
                                        this.getTurnManager(),
                                        this.getListPreConditions(),
                                        this.getListPostConditions(),
                                        postConditionResponse.message)
        }

        val boardAux : IBoard = this.getCurrentBoard().update(movement)
        val gameAuxBoards = this.getBoards().toMutableList()
        gameAuxBoards.add(boardAux)
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

    override fun getListPostConditions(): List<Validator> {
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

    private fun validatePostConditions(movement: Movement): ValidatorResponse {
        for (postCondition in getListPostConditions()){
            when (val postConditionResponse : ValidatorResponse = postCondition.validate(movement, this)) {
                is ValidatorResponse.ValidatorResultInvalid -> return postConditionResponse
                is ValidatorResponse.ValidatorResultValid -> continue
            }
        }
        return ValidatorResponse.ValidatorResultValid("Se cumplen todas las postcondiciones")
    }

}