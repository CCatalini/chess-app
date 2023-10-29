package edu.austral.dissis.chess.validator

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement

class IsFirstMoveValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()
        val fromPiece = board.getPieceByPosition(movement.from) ?: return ValidatorResponse.ValidatorResultInvalid("No hay una pieza en esta posicion para mover")

        if (fromPiece.getMoveCounter() == 0) return ValidatorResponse.ValidatorResultValid("Es el primer movimiento")
        return ValidatorResponse.ValidatorResultInvalid("No es el primer movimiento")
    }


}
