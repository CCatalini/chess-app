package engine.board

import engine.piece.Piece

class BoardImpl(private val width: Int,
                private val height: Int,
                private val piecePositions: Map<Position, Piece>) : Board {

    override fun getWidth(): Int {
        return width
    }

    override fun getHeight(): Int {
        return height
    }

    override fun getPieceByPosition(position: Position): Piece? {
        return piecePositions[position]
    }

    override fun getPositionByPiece(piece: Piece): Position? {
        for (position in piecePositions.keys) {
            if (piecePositions[position] == piece) {
                return position
            }
        }
        return null
    }

    override fun getPiecesPositions(): Map<Position, Piece> {
        return piecePositions
    }
}