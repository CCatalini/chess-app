package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.validator.TurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.winCondition.WinCondition

class FinishGameState(private val boards : List<IBoard>,
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

    override fun getCurrentTurn(): Color {
        return turnManager.getTurn()
    }

    override fun movePiece(movement: Movement): IGameState {
        //porque termino el juego, devolviendo es this devuelve el mismo estado
        //santi dice que es un state pattern
        return this
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
}