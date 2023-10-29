package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

class IsEnemyValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()

        board.getPieceByPosition(movement.to)?.let {
            if (it.getColor() != gameState.getCurrentTurn())
                return ValidatorResponse.ValidatorResultValid("Es enemigo")
        }
        return ValidatorResponse.ValidatorResultInvalid("No es enemigo")
    }
}