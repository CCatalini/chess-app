package edu.austral.dissis.common.board

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.piece.Piece

class Board(private val width: Int,
            private val height: Int,
            private val piecePositions: Map<Position, Piece> ) : IBoard {


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

    override fun update(movement: Movement): IBoard {
        val newPiecePositions = piecePositions.toMutableMap()
        newPiecePositions.remove(movement.from)
        newPiecePositions[movement.to] = piecePositions[movement.from]!!
        return Board(width, height, newPiecePositions)
    }

    override fun getOccupiedPositions(): List<Position> {
        return piecePositions.keys.toList()
    }

    override fun removePieceByPosition(position: Position): IBoard {
        val newPiecePositions = piecePositions.toMutableMap()
        newPiecePositions.remove(position)
        return Board(width, height, newPiecePositions)
    }

    override fun getPieces(): List<Piece> {
        return piecePositions.values.toList()
    }

    override fun updatePieceByPosition(position: Position, piece: Piece): IBoard {
        val newPiecePositions = piecePositions.toMutableMap()
        newPiecePositions[position] = piece
        return Board(width, height, newPiecePositions)
    }
}