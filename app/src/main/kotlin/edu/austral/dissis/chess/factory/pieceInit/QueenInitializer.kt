package edu.austral.dissis.chess.factory.pieceInit

import edu.austral.dissis.chess.factory.*
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceInitializer
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.composition.AndValidator
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
            AndValidator(
                listOf(
                    LegalPositionValidator(),
                    destinationPosition(),
                    OrValidator(
                        listOf(
                            horizontalMove(),
                            straightMove(),
                            diagonalMove()
                        )
                    )
                )
            )
        )
    }
}
/*

 */


/*

 */