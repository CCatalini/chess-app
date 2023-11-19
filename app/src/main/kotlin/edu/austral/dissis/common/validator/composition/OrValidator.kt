package edu.austral.dissis.common.validator.composition

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement

/** Clase que representa un 'O' lógico entre los Validator de la lista.
 * Tiene que ser válido algún validador de la lista para que este Validator sea válido*/
class OrValidator(private val validators: List<edu.austral.dissis.common.validator.Validator>) :
    edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        for (validator: edu.austral.dissis.common.validator.Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when ( validator.validate(movement, gameState)) {
                is edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid ->  return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
                is edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid ->  continue
            }

        }
        return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("Invalid move")
    }
}

