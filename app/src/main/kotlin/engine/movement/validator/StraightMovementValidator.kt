package movement.validator

import GameState
import movement.Movement

//incluir la validacion del sentido
class StraightMovementValidator : MovementValidator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isStraightMove(fromX, fromY, toX, toY)
    }

    private fun isStraightMove(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        return deltaX != 0 && deltaY == 0
    }

}