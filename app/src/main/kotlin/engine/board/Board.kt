package engine.board

import engine.piece.Piece

interface Board {

    fun getWidth(): Int
    fun getHeight(): Int

    fun getPieceByPosition(position: Position): Piece?
    fun getPositionByPiece(piece: Piece): Position?
    fun getPiecesPositions(): Map<Position, Piece>
}