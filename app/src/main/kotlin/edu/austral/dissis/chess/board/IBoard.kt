package edu.austral.dissis.chess.board

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Piece

interface IBoard {

    fun getWidth(): Int
    fun getHeight(): Int

    fun getPieceByPosition(position: Position): Piece?
    fun getPositionByPiece(piece: Piece): Position?
    fun getPiecesPositions(): Map<Position, Piece>
    fun update(movement: Movement): Any
}