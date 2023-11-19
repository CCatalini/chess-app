package edu.austral.dissis.chess.validator.turn

import edu.austral.dissis.common.ITurnValidator
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.common.validator.ValidatorResponse

class ChessTurnValidator(private val current: Color) : ITurnValidator {

    override fun getTurn(): Color {
        return current
    }

    override fun nextTurn(): ITurnValidator {
        return if (current == Color.WHITE) {
            ChessTurnValidator(Color.BLACK)
        } else {
            ChessTurnValidator(Color.WHITE)
        }
    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        val pieceToMove: Piece? = getPiece(movement, gameState)

        if (pieceToMove != null) {
            if (pieceToMove.getColor() == this.current) {
                return ValidatorResponse.ValidatorResultValid("Es tu turno")
            }
        }
        return ValidatorResponse.ValidatorResultInvalid("No es tu turno capo")
    }

    private fun getPiece (movement: Movement, gameState: IGameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(movement.to)
    }



}