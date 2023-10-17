package engine.movement.validator

import GameState
import engine.movement.Movement

//TODO;
class StraightValidator (private val limit: Int, private val direction: Int) : Validator {

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