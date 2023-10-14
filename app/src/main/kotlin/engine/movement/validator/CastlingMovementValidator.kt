package movement.validator

import GameState
import movement.Movement

// para el enroque
class CastlingMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        return true
    }
}