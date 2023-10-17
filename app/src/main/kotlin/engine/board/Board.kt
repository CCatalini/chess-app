package engine.board

import engine.movement.Movement
import engine.piece.Piece

interface Board {

    fun getWidth(): Int
    fun getHeight(): Int

    fun getPieceByPosition(position: Position): Piece?
    fun getPositionByPiece(piece: Piece): Position?
    fun getPiecesPositions(): Map<Position, Piece>
    fun update(movement: Movement): Any
}