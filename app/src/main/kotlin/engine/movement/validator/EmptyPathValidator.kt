package engine.movement.validator

import GameState
import engine.board.Position
import engine.movement.Movement

// para ver que el camino esta vacio
class EmptyPathValidator : MovementValidator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {

        TODO("Not yet implemented")
    }


    private fun  getPositionByPiece(position: Position, gameState: GameState) {

    }
}