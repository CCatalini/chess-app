package engine.movement.validator

import GameState
import engine.movement.Movement

// para el enroque
class CastlingValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        return true
    }
}