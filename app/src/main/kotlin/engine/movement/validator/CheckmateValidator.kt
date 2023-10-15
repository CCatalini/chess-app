package engine.movement.validator

import GameState
import engine.movement.Movement

//para ver si un jugador queda en jaquemate
class CheckmateValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}