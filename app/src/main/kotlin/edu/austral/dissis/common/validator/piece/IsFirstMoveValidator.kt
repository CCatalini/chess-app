package edu.austral.dissis.common.validator.piece

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement

class IsFirstMoveValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        val board = gameState.getCurrentBoard()
        val fromPiece = board.getPieceByPosition(movement.from) ?: return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("No hay una pieza en esta posicion para mover")

        if (fromPiece.getMoveCounter() == 0) return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("Es el primer movimiento")
        return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("No es el primer movimiento")
    }


}
