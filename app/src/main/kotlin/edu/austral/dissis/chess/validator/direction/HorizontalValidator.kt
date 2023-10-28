package edu.austral.dissis.chess.validator.direction

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Clase para verificar que el movimiento de una pieza es horizontal. */
class HorizontalValidator: Validator {

    override fun validate(movement: Movement, gameState: GameState) : ValidatorResponse{
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isHorizontalMove(fromX, fromY, toX, toY)
    }

    private fun isHorizontalMove(fromX: Int, fromY: Int, toX: Int, toY: Int): ValidatorResponse {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        return  if (deltaX == 0 && deltaY != 0) ValidatorResponse.ValidatorResultValid("OK")
                else ValidatorResponse.ValidatorResultInvalid("No es un movimiento horizontal.")
    }
}