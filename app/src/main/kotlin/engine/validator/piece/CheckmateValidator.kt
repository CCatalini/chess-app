package engine.validator.piece

import GameState
import engine.movement.Movement
import engine.validator.Validator

//para ver si un jugador queda en jaquemate
class CheckmateValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}