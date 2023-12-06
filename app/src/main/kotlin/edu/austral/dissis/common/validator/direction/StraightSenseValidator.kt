package edu.austral.dissis.common.validator.direction

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class StraightSenseValidator(private val sense: Int) : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        if (movement.from.column != movement.to.column) {
            return ValidatorResponse.ValidatorResultInvalid("No es un movimiento recto")
        }

        val isValidMove = when (sense) {
            1 -> movement.from.row < movement.to.row
            -1 -> movement.from.row > movement.to.row
            else -> false
        }

        return if (isValidMove) {
            ValidatorResponse.ValidatorResultValid("OK")
        } else {
            ValidatorResponse.ValidatorResultInvalid("No es un sentido válido")
        }
    }

}