package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

class AndValidator( private val validators : List<Validator>) : Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        for (validator : Validator in validators) {
            if (!validator.validate(movement, gameState)) {
                return false
            }
        }
        return true
    }
}