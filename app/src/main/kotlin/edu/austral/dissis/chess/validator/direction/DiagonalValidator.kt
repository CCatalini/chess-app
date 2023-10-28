package edu.austral.dissis.chess.validator.direction

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse
import kotlin.math.abs

/** Clase para verificar que el movimiento de una pieza es diagonal*/
class DiagonalValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isDiagonalMove(fromX, fromY, toX, toY)
    }

    private fun isDiagonalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): ValidatorResponse {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        // Un movimiento es diagonal si la magnitud del cambio en X es igual a la magnitud del cambio en Y
        return  if (abs(deltaX) == abs(deltaY)) ValidatorResponse.ValidatorResultValid("OK")
                else ValidatorResponse.ValidatorResultInvalid("No es un movimiento diagonal.")
    }

}
