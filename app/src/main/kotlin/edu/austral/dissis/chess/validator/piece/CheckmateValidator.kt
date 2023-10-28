package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

//para ver si un jugador queda en jaquemate
class CheckmateValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        TODO("Not yet implemented")
    }
}