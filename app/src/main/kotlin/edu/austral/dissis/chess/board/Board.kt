package edu.austral.dissis.chess.board

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Piece

class Board(private val width: Int,
            private val height: Int,
            private val piecePositions: Map<Position, Piece> ) : IBoard {

    fun movePiece(from: Position, to: Position): Board {
        val piece: Piece = this.piecePositions[from]?: throw NoSuchElementException("No piece at $from")

        return Board(width, height, piecePositions +
                                                Pair(to, piece.copy(moveCounter = piece.getMoveCounter() + 1,
                                                                    id = piece.getId()) ) - from)
    }

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
    override fun update(movement: Movement): IBoard {
        val newPiecePositions = piecePositions.toMutableMap()
        newPiecePositions.remove(movement.from)
        newPiecePositions[movement.to] = piecePositions[movement.from]!!
        return Board(width, height, newPiecePositions)
    }
}