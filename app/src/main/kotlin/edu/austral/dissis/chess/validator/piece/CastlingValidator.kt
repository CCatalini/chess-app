package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator

// para el enroque
class CastlingValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        return true
    }
}