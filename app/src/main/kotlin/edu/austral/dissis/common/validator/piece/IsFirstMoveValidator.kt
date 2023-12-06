package edu.austral.dissis.common.validator.piece

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class IsFirstMoveValidator : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()
        val fromPiece = board.getPieceByPosition(movement.from) ?: return ValidatorResponse.ValidatorResultInvalid("No hay una pieza en esta posicion para mover")

        if (fromPiece.getMoveCounter() == 0) return ValidatorResponse.ValidatorResultValid("Es el primer movimiento")
        return ValidatorResponse.ValidatorResultInvalid("No es el primer movimiento")
    }


}
