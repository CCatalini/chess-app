import engine.board.Board
import engine.movement.Movement
import engine.piece.Color

//guarda una lista de tableros que registra todos los movimientos realizados a lo largo del juego
interface GameState{

    fun getBoards(): List<Board>
    fun getCurrentBoard(): Board

    //para hacer el movimiento, agregar tablero a la lista y que cambie el turno
    fun updateState(movement: Movement): GameState
    fun getCurrentTurn(): Color

}