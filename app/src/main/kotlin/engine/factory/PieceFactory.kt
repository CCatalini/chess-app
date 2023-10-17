package engine.factory

import engine.movement.validator.ColorValidator
import engine.movement.validator.StraightValidator
import engine.piece.Color
import engine.piece.Pawn
import engine.piece.Piece

class PieceFactory {
    companion object {

        private var id = '0'
/*
        fun createPawn (color: Color) : Piece {
            val rules = listOf(
                StraightValidator(1),
                ColorValidator()
            )

            return Pawn("" + id++, color, rules )
        }

 */
    }
}