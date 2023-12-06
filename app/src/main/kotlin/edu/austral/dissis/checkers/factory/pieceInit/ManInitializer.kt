package edu.austral.dissis.checkers.factory.pieceInit

import edu.austral.dissis.checkers.validator.EnemyInBetween
import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.board.ExactMovementValidator
import edu.austral.dissis.common.validator.direction.VerticalSenseValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator

class ManInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        val sense = if (color == Color.WHITE) 1 else -1

        return Piece(id,
            color,
            PieceType.CheckersPieceType.MAN,
            OrValidator(
                listOf(
                    // movimiento simple en diagonal
                    AndValidator(listOf(
                        DiagonalValidator(),
                        LimitedMovementValidator(1),
                        VerticalSenseValidator(sense)
                    )),

                    // captura en diagonal, tiene que caer atrás (en diagonal) de la que se come
                    AndValidator(listOf(
                        VerticalSenseValidator(sense),
                        DiagonalValidator(),
                        ExactMovementValidator(2),
                        EnemyInBetween(),
                        EmptyDestinationValidator()
                    )),

                    //crown


                )
            )
        )
    }

}