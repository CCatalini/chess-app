package engine.board

import engine.movement.Movement
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

    //todo --> validar el movimiento de la pieza, si es verdadero actualizar, si es falso devolver el mismo tablero
    override fun update(movement: Movement): Board {
        val newPiecePositions = piecePositions.toMutableMap()
        newPiecePositions.remove(movement.from)
        newPiecePositions[movement.to] = piecePositions[movement.from]!!
        return BoardImpl(width, height, newPiecePositions)
    }
}