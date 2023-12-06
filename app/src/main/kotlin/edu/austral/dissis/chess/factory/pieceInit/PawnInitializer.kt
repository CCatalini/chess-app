package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.VerticalSenseValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator
import edu.austral.dissis.common.validator.obstacle.StraightEmptyPathValidator
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
            PieceType.ChessPieceType.PAWN,
            AndValidator(
                listOf(

                    LegalPositionValidator(),

                    OrValidator(
                        listOf(

                            AndValidator(
                                listOf(
                                    StraightValidator(),
                                    StraightEmptyPathValidator(),
                                    LimitedMovementValidator(1),
                                    EmptyDestinationValidator(),

                                    VerticalSenseValidator(sense)
                                )
                            ),

                            AndValidator(
                                listOf( // para el primer movimiento
                                    IsFirstMoveValidator(),
                                    StraightValidator(),
                                    StraightEmptyPathValidator(),
                                    LimitedMovementValidator(2),
                                    EmptyDestinationValidator(),

                                    VerticalSenseValidator(sense)

                                )
                            ),

                            AndValidator(
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