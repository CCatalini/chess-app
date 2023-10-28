package edu.austral.dissis.chess.validator.direction

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Clase para verificar que el movimiento de una pieza es recto. */
class StraightValidator () : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column

        return isStraightMove(fromX, fromY, toX, toY)
    }

    private fun isStraightMove(fromX: Int, fromY: Int, toX: Int, toY: Int): ValidatorResponse {
        val deltaX = toX - fromX
        val deltaY = toY - fromY

        return  if (deltaX != 0 && deltaY == 0) ValidatorResponse.ValidatorResultValid("OK")
                else ValidatorResponse.ValidatorResultInvalid("No es un movimiento recto.")
    }

}