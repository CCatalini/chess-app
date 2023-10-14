package board

import piece.Piece

class BoardImpl(private val width: Int,
                private val height: Int,
                private val positions: Map<Position, Piece>) : Board{

    override fun getPieceByPosition(position: Position): Piece? {
        return positions[position]
    }

    override fun getWidth(): Int {
        return width
    }

    override fun getHeight(): Int {
        return height
    }

    override fun getPositionByPiece(piece: Piece): Position? {
        for (position in positions.keys) {
            if (positions[position] == piece) {
                return position
            }
        }
        return null
    }
}