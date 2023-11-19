package edu.austral.dissis.common.validator.composition

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement

/** Clase que representa un 'Y' lógico entre los Validator de la lista.
 * Todos tienen que ser válidos para que este Validator sea válido*/
class AndValidator( private val validators : List<edu.austral.dissis.common.validator.Validator>) :
    edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        for (validator : edu.austral.dissis.common.validator.Validator in validators) {
            /** Pattern matching para evaluar las respuestas de cada validador de la lista. */
            when (validator.validate(movement, gameState)){
                is edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid -> continue
                is edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid -> return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("No es por ahi")
            }
        }
        return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
    }
}