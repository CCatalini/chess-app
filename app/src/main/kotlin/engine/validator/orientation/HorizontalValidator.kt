package engine.validator.orientation

import GameState
import engine.movement.Movement
import engine.validator.Validator

class HorizontalValidator: Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isHorizontalMove(fromX, fromY, toX, toY)
    }

    private fun isHorizontalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        return deltaX == 0 && deltaY != 0
    }
}