package engine.movement.validator

import GameState
import engine.movement.Movement

// para checkear que el peon de un color llegue al otro lado del tablero,en ese caso,
// permite que el peón se promocione a una pieza más poderosa (reina, torre, alfil o caballo).
class PromotionMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}