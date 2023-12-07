package edu.austral.dissis.checkers.factory.pieceInit

import edu.austral.dissis.checkers.factory.diagonalCaptureWithSense
import edu.austral.dissis.checkers.factory.simpleDiagonalMoveWithSense
import edu.austral.dissis.common.piece.PieceInitializer
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.composition.OrValidator

class ManInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        val sense = if (color == Color.WHITE) 1 else -1

        return Piece(id,
            color,
            PieceType.PAWN,
            OrValidator(
                listOf(
                    simpleDiagonalMoveWithSense(sense),
                    diagonalCaptureWithSense(sense)
                    //la coronación usa al promotion y es una post condition
                )
            )
        )
    }




}