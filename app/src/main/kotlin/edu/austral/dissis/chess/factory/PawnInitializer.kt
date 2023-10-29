package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.chess.validator.*
import edu.austral.dissis.chess.validator.board.LegalPositionValidator
import edu.austral.dissis.chess.validator.direction.DiagonalValidator
import edu.austral.dissis.chess.validator.direction.StraightValidator
import edu.austral.dissis.chess.validator.obstacle.StraightEmptyPathValidator
import edu.austral.dissis.chess.validator.piece.ColorValidator

class PawnInitializer :  PieceInitializer{

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return Piece(uuid,
            color,
            PieceType.PAWN,
            1, /*TODO VER !!!!!!! */
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