package edu.austral.dissis.common.validator.direction

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

/** Clase para verificar que el movimiento de una pieza es horizontal. */
class HorizontalValidator: Validator {

    override fun validate(movement: Movement, gameState: IGameState) : ValidatorResponse {

        return if (movement.from.row == movement.to.row) ValidatorResponse.ValidatorResultValid("OK")
        else ValidatorResponse.ValidatorResultInvalid("No es un movimiento horizontal.")
    }
}