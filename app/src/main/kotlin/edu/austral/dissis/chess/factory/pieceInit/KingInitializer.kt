package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.common.piece.PieceInitializer
import edu.austral.dissis.chess.factory.destinationPosition
import edu.austral.dissis.chess.validator.move.LongCastleValidator
import edu.austral.dissis.chess.validator.move.ShortCastleValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.HorizontalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator

class KingInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        return Piece(id,
            color,
            PieceType.KING,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    destinationPosition(),
                    OrValidator(
                        listOf(
                            AndValidator(
                                listOf(
                                    LimitedMovementValidator(1),
                                    OrValidator(
                                        listOf(
                                            StraightValidator(),
                                            DiagonalValidator(),
                                            HorizontalValidator(),
                                        )
                                    )
                                )
                            ),
                            ShortCastleValidator(),
                            LongCastleValidator()
                        )
                    ),
                )
            )

        )
    }
}
