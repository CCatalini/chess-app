package edu.austral.dissis.common.validator.piece

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class IsEnemyValidator : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()
        val piece = board.getPieceByPosition(movement.to)
        val pieceFrom = board.getPieceByPosition(movement.from)
            ?: return ValidatorResponse.ValidatorResultInvalid("no hay pieza capo")

        return if ( piece == null ) ValidatorResponse.ValidatorResultInvalid("no hay pieza capo")
        else {
            if (piece.color != pieceFrom.color) ValidatorResponse.ValidatorResultValid("es enemigo ")
            else ValidatorResponse.ValidatorResultInvalid("Pieza aliada en la posicion de destino")
        }

    }
}