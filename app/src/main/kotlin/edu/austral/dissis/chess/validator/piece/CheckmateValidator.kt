package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator

//para ver si un jugador queda en jaquemate
class CheckmateValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}