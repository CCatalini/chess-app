package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.chess.validator.KnightMoveValidator

class KnightInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {

        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.KNIGHT,
            KnightMoveValidator()
        )
    }
}