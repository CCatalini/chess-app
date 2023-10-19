package engine.validator.piece

import GameState
import engine.movement.Movement
import engine.validator.Validator

// para el enroque
class CastlingValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        return true
    }
}