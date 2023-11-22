package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.chess.factory.pieceInit.QueenInitializer
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position

class PromotionValidator : PostConditionValidator{

    override fun validate(gameState: IGameState, board: IBoard): PostConditionResult {

        val map = board.getPiecesPositions().toMutableMap()

        for(i in 0..7) {
            val pieceWhite = getPiece(Position(7,i), gameState)
            if ( pieceWhite!= null && isPawn(pieceWhite) && isColor(pieceWhite, Color.WHITE)) {
                map[Position(7,i)]= QueenInitializer().initialize(Color.WHITE, pieceWhite.id)
            }
            val pieceBlack = getPiece(Position(0,i), gameState)
            if (pieceBlack!= null && isPawn(pieceBlack) && isColor(pieceBlack, Color.BLACK)) {
                map[Position(0,i)]= QueenInitializer().initialize(Color.BLACK, pieceBlack.id)
            }
        }


        return PostConditionResult.ResultValid(Board(gameState.getCurrentBoard().getWidth(), gameState.getCurrentBoard().getHeight(), map))
    }

    private fun getPiece(position: Position, gameState: IGameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(position)
    }

    private fun isPawn(piece: Piece): Boolean {
        return if (piece == null) false
        else piece.type == PieceType.PAWN
    }

    private fun isColor(piece: Piece, color: Color): Boolean {
        return piece.color == color
    }
}