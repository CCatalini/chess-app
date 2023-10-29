package edu.austral.dissis.chess

import edu.austral.dissis.chess.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color

//guarda una lista de tableros que registra todos los movimientos realizados a lo largo del juego
interface GameState{

    fun getBoards(): List<IBoard>
    fun getCurrentBoard(): IBoard

    //para hacer el movimiento, agregar tablero a la lista y que cambie el turno
    fun updateState(movement: Movement): GameState
    fun getCurrentTurn(): Color

}