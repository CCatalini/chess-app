package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.chess.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.WinCondition

//guarda una lista de tableros que registra todos los movimientos realizados a lo largo del juego
/*
1 valido que la pieza no sea nula
2 valido el turno
3 valido los movimientos
4 (si los movimientos son correctos) hago creo un board aparte y lo uso para probar las win conditions
5 valido las win conditions y si gana le devuelvo un finished game, sino el devuelvo un current game
6 (si no son validos los mivmientos) retorno que no es un valid move
 */
sealed interface IGameState{

    fun getBoards(): List<IBoard>
    fun getCurrentBoard(): IBoard

    fun getCurrentTurn(): Color

    fun movePiece(movement: Movement) : IGameState

    fun getTurnManager() : TurnValidator

    fun getListPreConditions(): List<Validator>
    fun getListPostConditions() : List<PostConditionValidator>
    fun getWinCondition() : WinCondition

}


