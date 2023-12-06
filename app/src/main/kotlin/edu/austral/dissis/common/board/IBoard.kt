package edu.austral.dissis.common.board

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.piece.Piece

interface IBoard {

    fun getWidth(): Int
    fun getHeight(): Int

    fun getPieceByPosition(position: Position): Piece?
    fun getPositionByPiece(piece: Piece): Position?
    fun getPiecesPositions(): Map<Position, Piece>
    fun update(movement: Movement): IBoard
    fun getOccupiedPositions(): List<Position>

    fun getPieces(): List<Piece>

    fun updatePieceByPosition(position: Position, piece: Piece): IBoard

}