package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.chess.validator.AndValidator
import edu.austral.dissis.chess.validator.board.LegalPositionValidator
import edu.austral.dissis.chess.validator.direction.DiagonalValidator
import edu.austral.dissis.chess.validator.obstacle.DiagonalEmptyPathValidator

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