package edu.austral.dissis.common.validator.board

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement


// Clase para especificar cuantas casillas puede moverse una pieza
// Respeta un rango menor o igual al máximo establecido
class LimitedMovementValidator( private val maxMoveQuantity: Int ) : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {

        val horizontalDistance = kotlin.math.abs(movement.from.column - movement.to.column)
        val verticalDistance = kotlin.math.abs(movement.from.row - movement.to.row)

        val isHorizontalValid = horizontalDistance <= maxMoveQuantity
        val isVerticalValid = verticalDistance <= maxMoveQuantity

        return if (isHorizontalValid || isVerticalValid || isDiagonal(horizontalDistance, verticalDistance)) {
            edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("oka")
        } else {
            edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("Movement exceeds limit")
        }
    }

    private fun isDiagonal(horizontalDistance: Int, verticalDistance: Int): Boolean {
        return horizontalDistance == verticalDistance && horizontalDistance in 1..maxMoveQuantity
    }

}