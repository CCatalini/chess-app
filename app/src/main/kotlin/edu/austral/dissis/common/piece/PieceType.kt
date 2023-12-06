package edu.austral.dissis.common.piece

sealed interface PieceType {
    enum class CheckersPieceType : PieceType {
        MAN,
        QUEEN
    }

    enum class ChessPieceType : PieceType {
        PAWN,
        ROOK,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING,

        ARCHBISHOP,
        CHANCELLOR,
        JEDIKNIGHT
    }
}
