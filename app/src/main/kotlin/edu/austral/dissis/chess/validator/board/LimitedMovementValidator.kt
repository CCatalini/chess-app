package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse


// Clase para especificar cuantas casillas puede moverse una pieza
// Respeta un rango menor o igual al máximo establecido
class LimitedMovementValidator( private val maxMoveQuantity: Int ) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {

        val horizontalDistance = kotlin.math.abs(movement.from.column - movement.to.column)
        val verticalDistance = kotlin.math.abs(movement.from.row - movement.to.row)

        val isHorizontalValid = horizontalDistance <= maxMoveQuantity
        val isVerticalValid = verticalDistance <= maxMoveQuantity

        return if (isHorizontalValid || isVerticalValid || isDiagonal(horizontalDistance, verticalDistance)) {
            ValidatorResponse.ValidatorResultValid("oka")
        } else {
            ValidatorResponse.ValidatorResultInvalid("Movement exceeds limit")
        }
    }

    private fun isDiagonal(horizontalDistance: Int, verticalDistance: Int): Boolean {
        return horizontalDistance == verticalDistance && horizontalDistance in 1..maxMoveQuantity
    }

}