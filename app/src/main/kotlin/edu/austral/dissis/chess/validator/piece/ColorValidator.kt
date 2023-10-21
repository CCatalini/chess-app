package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.validator.Validator

class ColorValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val targetPiece: Piece? = getTargetPiece(movement, gameState)

        if (targetPiece != null) {
            if (targetPiece.getColor() == gameState.getCurrentTurn()) {
                return true
            }
        }
        return false
    }

    private fun getTargetPiece (movement: Movement, gameState: GameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(movement.to)
    }



}