package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

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