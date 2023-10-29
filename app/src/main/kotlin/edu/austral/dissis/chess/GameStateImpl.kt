package edu.austral.dissis.chess

import edu.austral.dissis.chess.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color

class GameStateImpl(private val boards : List<IBoard>) : GameState {



    override fun getBoards(): List<IBoard> {
        return boards
    }

    override fun getCurrentBoard(): IBoard {
        return boards.last()
    }

    override fun updateState(movement: Movement): GameState {
        val boardsCopy : List<IBoard> = boards.toMutableList()
        val newIBoard : IBoard = getCurrentBoard().update(movement) as IBoard

        val toReturn : List<IBoard> =  boardsCopy + newIBoard

        return GameStateImpl(toReturn)
    }

    override fun getCurrentTurn(): Color {
        TODO("Not yet implemented")
    }
}