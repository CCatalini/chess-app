package edu.austral.dissis.chess

import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color

class GameStateImpl(private val boards : List<Board>) : GameState {



    override fun getBoards(): List<Board> {
        return boards
    }

    override fun getCurrentBoard(): Board {
        return boards.last()
    }

    override fun updateState(movement: Movement): GameState {
        val boardsCopy : List<Board> = boards.toMutableList()
        val newBoard : Board = getCurrentBoard().update(movement) as Board

        val toReturn : List<Board> =  boardsCopy + newBoard

        return GameStateImpl(toReturn)
    }

    override fun getCurrentTurn(): Color {
        TODO("Not yet implemented")
    }
}