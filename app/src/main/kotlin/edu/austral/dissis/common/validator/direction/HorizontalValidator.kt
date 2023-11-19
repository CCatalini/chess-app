package edu.austral.dissis.common.validator.direction

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement

/** Clase para verificar que el movimiento de una pieza es horizontal. */
class HorizontalValidator: edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState) : edu.austral.dissis.common.validator.ValidatorResponse {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isHorizontalMove(fromX, fromY, toX, toY)
    }

    private fun isHorizontalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): edu.austral.dissis.common.validator.ValidatorResponse {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        return  if (deltaX == 0 && deltaY != 0) edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
                else edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("No es un movimiento horizontal.")
    }
}