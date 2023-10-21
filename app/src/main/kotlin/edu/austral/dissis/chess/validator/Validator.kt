package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

/** Va a ser implementada por cada regla y movimiento que necesita una validación */
interface Validator {

    fun validate(movement: Movement, gameState: GameState): ValidatorResponse

}