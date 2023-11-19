package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.obstacle.DiagonalEmptyPathValidator

class BishopInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.BISHOP,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    DiagonalValidator(),
                    DiagonalEmptyPathValidator()
                )
            )
        )
    }
}