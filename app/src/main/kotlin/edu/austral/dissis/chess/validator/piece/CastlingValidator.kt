package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

// para el enroque
class CastlingValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        TODO("Not yet implemented")
    }
}