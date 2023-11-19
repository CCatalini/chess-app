package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.HorizontalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator

class KingInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.KING,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    OrValidator(
                        listOf(
                            AndValidator(
                                listOf(
                                    OrValidator(
                                        listOf(
                                            HorizontalValidator(),
                                            StraightValidator(),
                                            DiagonalValidator(),
                                        )
                                    ),
                                    LimitedMovementValidator(1)
                                )
                            )
                        )
                        //TODO -> enroque validator
                    )
                )
            )
        )
    }
}