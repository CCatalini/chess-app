package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.common.piece.PieceInitializer
import edu.austral.dissis.chess.factory.destinationPosition
import edu.austral.dissis.chess.factory.diagonalMove
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.composition.AndValidator

class BishopInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        return Piece(id,
            color,
            PieceType.BISHOP,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    diagonalMove(),
                    destinationPosition()
                )
            )
        )
    }
}