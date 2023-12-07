package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.common.piece.PieceInitializer
import edu.austral.dissis.chess.factory.straightMove
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.VerticalSenseValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator
import edu.austral.dissis.common.validator.piece.IsEnemyValidator
import edu.austral.dissis.common.validator.piece.IsFirstMoveValidator

class PawnInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {

        val sense = if (color == Color.WHITE) 1 else -1

        return Piece(id,
            color,
            PieceType.PAWN,
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    OrValidator(
                        listOf(
                            AndValidator(
                                listOf(
                                    straightMove(),
                                    LimitedMovementValidator(1),
                                    EmptyDestinationValidator(),
                                    VerticalSenseValidator(sense)
                                )
                            ),

                            AndValidator(
                                listOf( // para el primer movimiento
                                    IsFirstMoveValidator(),
                                    straightMove(),
                                    LimitedMovementValidator(2),
                                    EmptyDestinationValidator(),
                                    VerticalSenseValidator(sense)
                                )
                            ),

                            AndValidator(   // para comer
                                listOf(
                                    IsEnemyValidator(),
                                    DiagonalValidator(),
                                    LimitedMovementValidator(1)
                                )
                            )
                        )
                    )
                )
            )
        )
    }


}