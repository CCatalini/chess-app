package edu.austral.dissis.common.validator.board

import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class ExactMovementValidator(private val distance: Int) : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val horizontalDistance = kotlin.math.abs(movement.from.column - movement.to.column)
        val verticalDistance = kotlin.math.abs(movement.from.row - movement.to.row)
        return if (horizontalDistance == distance || verticalDistance == distance) {
            ValidatorResponse.ValidatorResultValid("Valid")
        } else {
            ValidatorResponse.ValidatorResultInvalid("Invalid")
        }
    }

}
