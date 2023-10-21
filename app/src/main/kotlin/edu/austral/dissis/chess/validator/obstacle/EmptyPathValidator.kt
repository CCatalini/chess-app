package edu.austral.dissis.chess.validator.obstacle

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator

// para ver que el camino esta vacio
// TODO implementar empty en cada direccion (diagonal, vertical, horizontal)
class EmptyPathValidator : Validator {

    //agregar pos inicial, ir iterando una pos y comparar cada posición con las posiciones del mapa,
    // la idea es que no este en el mapa porque el mapa guarda las posiciones ocupadas
    override fun validate(movement: Movement, gameState: GameState): Boolean {

        TODO("Not yet implemented")
    }


    private fun  getPositionByPiece(position: Position, gameState: GameState) {

    }
}