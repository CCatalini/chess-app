package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.chess.validator.AndValidator
import edu.austral.dissis.chess.validator.OrValidator
import edu.austral.dissis.chess.validator.board.LegalPositionValidator
import edu.austral.dissis.chess.validator.direction.HorizontalValidator
import edu.austral.dissis.chess.validator.direction.KnightMoveValidator
import edu.austral.dissis.chess.validator.direction.StraightValidator
import edu.austral.dissis.chess.validator.obstacle.HorizontalEmptyPathValidator
import edu.austral.dissis.chess.validator.obstacle.StraightEmptyPathValidator

class KnightInitializer : PieceInitializer{

    override fun initialize(color: Color): Piece {

        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.KNIGHT,
            KnightMoveValidator()
        )
    }
}