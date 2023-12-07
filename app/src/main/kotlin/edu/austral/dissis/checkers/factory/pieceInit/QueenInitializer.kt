package edu.austral.dissis.checkers.factory.pieceInit

import edu.austral.dissis.checkers.factory.diagonalCapture
import edu.austral.dissis.checkers.factory.simpleDiagonalMove
import edu.austral.dissis.chess.factory.PieceInitializer
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.composition.OrValidator

class QueenInitializer : PieceInitializer {

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return initialize(color, uuid)
    }

    override fun initialize(color: Color, id: String): Piece {
        return Piece(id,
            color,
            PieceType.QUEEN,
            OrValidator(
                listOf(
                    // movimiento simple en diagonal sin sentido determinado
                    simpleDiagonalMove(),
                    diagonalCapture()

                )
            )
        )

    }
}