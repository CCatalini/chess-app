package edu.austral.dissis.chess.validator.turn

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.validator.TurnValidator
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.validator.ValidatorResponse

class ChessTurnValidator(private val current: Color) : TurnValidator {

    override fun getTurn(): Color {
        return current
    }

    override fun nextTurn(gameState: IGameState): TurnValidator {
        return if (current == Color.WHITE) {
            ChessTurnValidator(Color.BLACK)
        } else {
            ChessTurnValidator(Color.WHITE)
        }
    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        val pieceToMove: Piece? = getPiece(movement, gameState)

        if (pieceToMove != null) {
            if (pieceToMove.color == this.current) {
                return ValidatorResponse.ValidatorResultValid("Es tu turno")
            }
        }
        return ValidatorResponse.ValidatorResultInvalid("No es tu turno capo")
    }

    private fun getPiece (movement: Movement, gameState: IGameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(movement.from)
    }



}