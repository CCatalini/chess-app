package edu.austral.dissis.common.validator.direction

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.movement.Movement
import kotlin.math.abs

/** Clase para verificar que el movimiento de una pieza es diagonal*/
class DiagonalValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isDiagonalMove(fromX, fromY, toX, toY)
    }

    private fun isDiagonalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): edu.austral.dissis.common.validator.ValidatorResponse {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        // Un movimiento es diagonal si la magnitud del cambio en X es igual a la magnitud del cambio en Y
        return  if (abs(deltaX) == abs(deltaY)) edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
                else edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("No es un movimiento diagonal.")
    }

}
