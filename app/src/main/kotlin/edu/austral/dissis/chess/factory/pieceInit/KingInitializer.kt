package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.chess.validator.move.CastleLeftValidator
import edu.austral.dissis.chess.validator.move.CastleRightValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.HorizontalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator
import edu.austral.dissis.common.validator.piece.IsEnemyValidator

class KingInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        return Piece(id,
            color,
            PieceType.ChessPieceType.KING,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    OrValidator(
                        listOf(
                            IsEnemyValidator(),
                            EmptyDestinationValidator()
                        )
                    ),
                    OrValidator(
                        listOf(
                            AndValidator(
                                listOf(
                                    LimitedMovementValidator(1),
                                    OrValidator(
                                        listOf(
                                            StraightValidator(),
                                            DiagonalValidator(), // TODO -> LIMITE
                                            HorizontalValidator(),
                                        )
                                    )
                                )
                            ),
                            CastleRightValidator(),
                            CastleLeftValidator()
                        )
                    ),
                )
            )

        )
    }
}
