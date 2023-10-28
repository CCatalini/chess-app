package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Para checkear el turno del jugador. Deb*/
class ColorValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val pieceToMove: Piece? = getPiece(movement, gameState)

        if (pieceToMove != null) {
            if (pieceToMove.getColor() == gameState.getCurrentTurn()) {
                return ValidatorResponse.ValidatorResultValid("Es tu turno")
            }
        }
        return ValidatorResponse.ValidatorResultInvalid("No es tu turno capo")
    }

    private fun getPiece (movement: Movement, gameState: GameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(movement.to)
    }


}