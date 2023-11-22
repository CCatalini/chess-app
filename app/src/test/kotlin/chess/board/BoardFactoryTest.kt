package chess.board

import edu.austral.dissis.chess.factory.BoardFactory
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.board.Position
import org.junit.Assert
import org.junit.Test

class BoardFactoryTest {

    @Test
    fun createChessBoard() {
        val chessBoard: IBoard = BoardFactory.createChessBoard()

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 0))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 0))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 7))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 7))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 0))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 0))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 7))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 7))?.type)


    }
}
