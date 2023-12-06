package chess.board

import edu.austral.dissis.chess.factory.createClassicChessBoard
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.PieceType
import org.junit.Assert
import org.junit.Test

class BoardFactoryTest {

    @Test
    fun createChessBoard() {
        val chessBoard: IBoard = createClassicChessBoard()

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 0))?.color)
        Assert.assertEquals(PieceType.ChessPieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 0))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 7))?.color)
        Assert.assertEquals(PieceType.ChessPieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 7))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 0))?.color)
        Assert.assertEquals(PieceType.ChessPieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 0))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 7))?.color)
        Assert.assertEquals(PieceType.ChessPieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 7))?.type)


    }
}