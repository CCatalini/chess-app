package engine.validator.piece

import GameState
import engine.movement.Movement
import engine.piece.Piece
import engine.validator.Validator

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