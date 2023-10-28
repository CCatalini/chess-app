package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

// para checkear que el peon de un color llegue al otro lado del tablero, en ese caso,
// permite que el peón se promocione a una pieza más poderosa (reina, torre, alfil o caballo).
class PromotionValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        TODO("Not yet implemented")
    }
}