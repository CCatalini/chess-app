package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement


// Clase para especificar cuantas casillas puede moverse una pieza
// Respeta un rango menor o igual al máximo establecido
class LimitedMovementValidator( private val maxMoveQuantity: Int ) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {

        val horizontalDistance = kotlin.math.abs(movement.from.column - movement.to.column)
        val verticalDistance = kotlin.math.abs(movement.from.row - movement.to.row)

        return if (horizontalDistance <= maxMoveQuantity && verticalDistance <= maxMoveQuantity) {
            ValidatorResponse.ValidatorResultValid("oka")
        } else {
           ValidatorResponse.ValidatorResultInvalid("no respetas el limite")
        }
    }
}