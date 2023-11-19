package edu.austral.dissis.common.validator.piece

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class IsEnemyValidator : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()

        board.getPieceByPosition(movement.to)?.let {
            if (it.getColor() != gameState.getCurrentTurn())
                return ValidatorResponse.ValidatorResultValid("Es enemigo")
        }
        return ValidatorResponse.ValidatorResultInvalid("No es enemigo")
    }
}