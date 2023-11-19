package edu.austral.dissis.chess.game

import edu.austral.dissis.chess.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.common.ITurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.WinCondition

class InvalidMoveGameState (private val boards : List<IBoard>,
                            private val winCondition: WinCondition,
                            private val turnManager: ITurnValidator,
                            private val preConditions: List<Validator>,
                            private val postConditions: List<Validator>,
                            val errorMessage: String ) : IGameState {

    override fun getBoards(): List<IBoard> {
        return boards
    }

    override fun getCurrentBoard(): IBoard {
        return boards.last()
    }

    override fun getCurrentTurn(): Color {
        return turnManager.getTurn()
    }

    override fun movePiece(movement: Movement): IGameState {
       // TODO -> el del gamestateimpl
        return this
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
}
