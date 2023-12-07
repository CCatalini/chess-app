package edu.austral.dissis.common.validator.board

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

// Clase para especificar cuantas casillas puede moverse una pieza
// Respeta un rango menor o igual al máximo establecido
class LimitedMovementValidator( private val maxMoveQuantity: Int ) : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {

        val horizontalDistance = kotlin.math.abs(movement.from.column - movement.to.column)
        val verticalDistance = kotlin.math.abs(movement.from.row - movement.to.row)

        val isHorizontalValid = horizontalDistance <= maxMoveQuantity
        val isVerticalValid = verticalDistance <= maxMoveQuantity

        return if (isHorizontalValid && isVerticalValid ) {
            ValidatorResponse.ValidatorResultValid("oka")
        } else {
            ValidatorResponse.ValidatorResultInvalid("Movement exceeds limit")
        }
    }

}