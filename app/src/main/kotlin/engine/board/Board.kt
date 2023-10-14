package board

import piece.Piece

interface Board {

    fun getPieceByPosition(position: Position): Piece?
    fun getWidth(): Int
    fun getHeight(): Int
    fun getPositionByPiece(piece: Piece): Position?


}