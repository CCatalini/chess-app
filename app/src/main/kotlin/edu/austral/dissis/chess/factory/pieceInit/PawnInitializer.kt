package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import edu.austral.dissis.common.validator.obstacle.StraightEmptyPathValidator
import edu.austral.dissis.common.validator.piece.IsEnemyValidator
import edu.austral.dissis.common.validator.piece.IsFirstMoveValidator

class PawnInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.PAWN,
            AndValidator(
                listOf(

                    LegalPositionValidator(),

                    OrValidator(
                        listOf(

                            AndValidator(
                                listOf(
                                    StraightValidator(),
                                    StraightEmptyPathValidator(),
                                    LimitedMovementValidator(1)
                                )
                            ),

                            AndValidator(
                                listOf( // para el primer movimiento
                                    IsFirstMoveValidator(),
                                    StraightValidator(),
                                    StraightEmptyPathValidator(),
                                    LimitedMovementValidator(2)

                                )
                            ),

                            AndValidator(
                                listOf(
                                    IsEnemyValidator(),
                                    DiagonalValidator(),
                                    LimitedMovementValidator(1)
                                )
                            )

                            //TODO PromotionValidator()


                        )
                    )
                )
            )
        )
    }

}