package edu.austral.dissis.common.validator

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement

/** Va a ser implementada por cada regla y movimiento que necesita una validación */
interface Validator {

    fun validate(movement: Movement, gameState: IGameState): ValidatorResponse

}