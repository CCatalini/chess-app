package edu.austral.dissis.chess.game

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.chess.validator.postCondition.PostConditionResult
import edu.austral.dissis.chess.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.WinCondition

class GameState(private val boards : List<IBoard>,
                private val winCondition: WinCondition,
                private val turnManager: TurnValidator,
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
        val turnResponse : ValidatorResponse = validateTurn(movement)
        if ( turnResponse is ValidatorResponse.ValidatorResultInvalid)          return invalidMove(turnResponse)

        //valida los movimientos
        val pieceMoveResponse : ValidatorResponse = validatePieceMove(movement)
        if (pieceMoveResponse is ValidatorResponse.ValidatorResultInvalid)      return invalidMove(pieceMoveResponse)

        //valida las precondiciones
        val preConditionResponse : ValidatorResponse = validatePreConditions(movement)
        if (preConditionResponse is ValidatorResponse.ValidatorResultInvalid)   return invalidMove(preConditionResponse)

        //valida las postCondiciones
        val boardAux: IBoard = this.getCurrentBoard().update(movement)

        val postConditionResponse : PostConditionResult = validatePostConditions(boardAux)
        val gamePostConditions : IGameState = updateGameStateAfterPostConditions(postConditionResponse,boardAux)

        //valida las winConditions
        if (getWinCondition().isWin(gamePostConditions))  return finishedGame(gamePostConditions)

        //incrementa el contador de movimientos de la pieza una vez que se validaron todas las condiciones
        val piece : Piece = this.getCurrentBoard().getPieceByPosition(movement.from)!!
        piece.incrementMoveCounter()

        return GameState(gamePostConditions.getBoards(),
                            this.getWinCondition(),
                            this.getTurnManager().nextTurn(),
                            this.getListPreConditions(),
                            this.getListPostConditions())
    }



    override fun getTurnManager(): TurnValidator {
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



    private fun validateTurn(movement: Movement): ValidatorResponse {
        return turnManager.validateTurn(movement, this)
    }

    private fun invalidMove(response: ValidatorResponse.ValidatorResultInvalid): IGameState {
        return InvalidMoveGameState(this.getBoards(),
                                    this.getWinCondition(),
                                    this.getTurnManager(),
                                    this.getListPreConditions(),
                                    this.getListPostConditions(),
                                    response.message)
    }

    private fun validatePreConditions(movement: Movement): ValidatorResponse {
        for (preCondition in getListPreConditions()) {
            val res : ValidatorResponse = preCondition.validate(movement, this)
            if ( res is ValidatorResponse.ValidatorResultInvalid) {
                return res
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }


    private fun validatePieceMove(movement: Movement): ValidatorResponse {
        val piece = getCurrentBoard().getPieceByPosition(movement.from) ?: return ValidatorResponse.ValidatorResultInvalid("No hay una pieza en esta posición para mover")
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

    private fun updateGameStateAfterPostConditions(postConditionResponse: PostConditionResult, boardAux: IBoard): IGameState {
        return if (postConditionResponse is PostConditionResult.ResultValid) {
            GameState(this.getBoards().toMutableList().apply { add(postConditionResponse.board) },
                    this.getWinCondition(),
                    this.getTurnManager(),
                    this.getListPreConditions(),
                    this.getListPostConditions())
        } else {
            GameState(this.getBoards().toMutableList().apply { add(boardAux) },
                    this.getWinCondition(),
                    this.getTurnManager(),
                    this.getListPreConditions(),
                    this.getListPostConditions())
        }
    }

    private fun finishedGame(gamePostConditions: IGameState): IGameState {
        return FinishGameState(gamePostConditions.getBoards(),
                                gamePostConditions.getWinCondition(),
                                gamePostConditions.getTurnManager(),
                                gamePostConditions.getListPreConditions(),
                                gamePostConditions.getListPostConditions())
    }
}