package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.chess.factory.pieceInit.QueenInitializer
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.PieceType

class PromotionValidator : PostConditionValidator{

    override fun validate(gameState: IGameState, board: IBoard): PostConditionResult {

        var newBoard = board

        for(i in 0..7) {
            val pieceWhite = getPiece(Position(7,i), newBoard)
            if ( pieceWhite!= null && isPawn(pieceWhite) && isColor(pieceWhite, Color.WHITE)) {
                val newPiece = QueenInitializer().initialize(Color.WHITE, pieceWhite.id)
                val valPiece = newBoard.getPieceByPosition(Position(7,i))
                newBoard = newBoard.updatePieceByPosition(Position(7,i), valPiece!!.copy(type = PieceType.ChessPieceType.QUEEN, validator = newPiece.validator))
            }
            val pieceBlack = getPiece(Position(0,i), newBoard)
            if (pieceBlack!= null && isPawn(pieceBlack) && isColor(pieceBlack, Color.BLACK)) {
                val newPiece = QueenInitializer().initialize(Color.BLACK, pieceBlack.id)
                val valPiece = newBoard.getPieceByPosition(Position(0,i))

                newBoard = newBoard.updatePieceByPosition(Position(0,i), valPiece!!.copy(type = PieceType.ChessPieceType.QUEEN, validator = newPiece.validator))
            }
        }

        return PostConditionResult.ResultValid(newBoard)
    }

    private fun getPiece(position: Position, board: IBoard): Piece? {
        return board.getPieceByPosition(position)
    }

    private fun isPawn(piece: Piece): Boolean {
        return piece.type == PieceType.ChessPieceType.PAWN
    }

    private fun isColor(piece: Piece, color: Color): Boolean {
        return piece.color == color
    }
}