package engine.factory

import engine.piece.Color
import engine.piece.Piece
import engine.piece.PieceImpl
import engine.piece.PieceType
import engine.validator.AndValidator
import engine.validator.OrValidator
import engine.validator.board.LegalPositionValidator
import engine.validator.obstacle.HorizontalEmptyPathValidator
import engine.validator.orientation.HorizontalValidator
import engine.validator.orientation.StraightValidator

class RookInitializer : PieceInitializer{

    override fun initialize(color: Color): Piece {
        val uuid = java.util.UUID.randomUUID().toString()
        return PieceImpl(uuid, color, PieceType.ROOK, AndValidator(
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
                                // sacar el límite porque si se modifica el tablero queda el limite harcodeado
                                // agregar que el limite de los movimientos sea un propio validador
                                StraightValidator(8,1),
                                HorizontalEmptyPathValidator()
                            )
                        ),
                        AndValidator(
                            listOf(
                                StraightValidator(8,-1),
                                HorizontalEmptyPathValidator()
                            )
                        ),
                    )
                )
            )
        ))
    }
}