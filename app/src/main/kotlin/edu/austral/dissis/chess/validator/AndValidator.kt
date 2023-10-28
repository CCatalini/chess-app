package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

/** Clase que representa un 'Y' lógico entre los Validator de la lista.
 * Todos tienen que ser válidos para que este Validator sea válido*/
class AndValidator( private val validators : List<Validator>) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        for (validator : Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when (validator.validate(movement, gameState)){
                is ValidatorResponse.ValidatorResultValid   -> continue
                is ValidatorResponse.ValidatorResultInvalid -> return ValidatorResponse.ValidatorResultInvalid("No es por ahi")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }
}