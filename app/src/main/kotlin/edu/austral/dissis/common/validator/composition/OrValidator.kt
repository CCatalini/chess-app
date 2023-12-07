package edu.austral.dissis.common.validator.composition

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

/** Clase que representa un 'O' lógico entre los Validator de la lista.
 * Tiene que ser válido algún validador de la lista para que este Validator sea válido*/
class OrValidator(private val validators: List<Validator>) : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        for (validator: Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when ( validator.validate(movement, gameState)) {
                is ValidatorResponse.ValidatorResultValid ->  return ValidatorResponse.ValidatorResultValid("OK")
                is ValidatorResponse.ValidatorResultInvalid ->  continue
            }

        }
        return ValidatorResponse.ValidatorResultInvalid("Invalid move")
    }
}

