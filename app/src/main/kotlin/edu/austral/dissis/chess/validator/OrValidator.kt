package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

/** Clase que representa un 'O' lógico entre los Validator de la lista.
 * Tiene que ser válido algún validador de la lista para que este Validator sea válido*/
class OrValidator(private val validators: List<Validator>) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        for (validator: Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when ( validator.validate(movement, gameState)) {
                is ValidatorResponse.ValidatorResultValid   ->  return ValidatorResponse.ValidatorResultValid("OK")
                is ValidatorResponse.ValidatorResultInvalid ->  continue
            }

        }
        return ValidatorResponse.ValidatorResultInvalid("Invalid move")
    }
}

