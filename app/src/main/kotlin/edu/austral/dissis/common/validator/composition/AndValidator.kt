package edu.austral.dissis.common.validator.composition

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

/** Clase que representa un 'Y' lógico entre los Validator de la lista.
 * Todos tienen que ser válidos para que este Validator sea válido*/
class AndValidator( private val validators : List<Validator>) : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        for (validator : Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when (validator.validate(movement, gameState)){
                is ValidatorResponse.ValidatorResultValid -> continue
                is ValidatorResponse.ValidatorResultInvalid -> return ValidatorResponse.ValidatorResultInvalid("No es por ahi")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }
}