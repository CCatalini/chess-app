package edu.austral.dissis.chess.validator.direction

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import kotlin.math.abs

class DiagonalValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isDiagonalMove(fromX, fromY, toX, toY)
    }

    private fun isDiagonalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        // Un movimiento es diagonal si la magnitud del cambio en X es igual a la magnitud del cambio en Y
        return abs(deltaX) == abs(deltaY)
    }
}
