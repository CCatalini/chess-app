package engine.board

import engine.board.Position
import engine.piece.Piece

interface Board {

    fun getPieceByPosition(position: Position): Piece?
    fun getWidth(): Int
    fun getHeight(): Int
    fun getPositionByPiece(piece: Piece): Position?


}