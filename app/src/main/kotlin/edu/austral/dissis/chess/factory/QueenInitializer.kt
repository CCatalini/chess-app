package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.chess.validator.AndValidator
import edu.austral.dissis.chess.validator.OrValidator
import edu.austral.dissis.chess.validator.board.LegalPositionValidator
import edu.austral.dissis.chess.validator.direction.DiagonalValidator
import edu.austral.dissis.chess.validator.direction.HorizontalValidator
import edu.austral.dissis.chess.validator.direction.StraightValidator
import edu.austral.dissis.chess.validator.obstacle.DiagonalEmptyPathValidator
import edu.austral.dissis.chess.validator.obstacle.HorizontalEmptyPathValidator
import edu.austral.dissis.chess.validator.obstacle.StraightEmptyPathValidator

class QueenInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.QUEEN,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    OrValidator(
                        listOf(
                            AndValidator(
                                listOf(
                                    HorizontalValidator(),
                                    HorizontalEmptyPathValidator()
                                )
                            ),
                            AndValidator(
                                listOf(
                                    StraightValidator(),
                                    StraightEmptyPathValidator()
                                )
                            ),
                            AndValidator(
                                listOf(
                                    DiagonalValidator(),
                                    DiagonalEmptyPathValidator()
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}