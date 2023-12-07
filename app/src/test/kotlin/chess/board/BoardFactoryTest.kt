package chess.board

import edu.austral.dissis.chess.factory.createCapablancaChessBoard
import edu.austral.dissis.chess.factory.createClassicChessBoard
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.PieceType
import org.junit.Assert
import org.junit.Test

class BoardFactoryTest {

    @Test
    fun createChessBoard() {
        val chessBoard: IBoard = createClassicChessBoard()

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 0))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 0))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 7))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 7))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 0))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 0))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(7, 7))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(7, 7))?.type)


    }

    @Test
    fun createCapablancaBoardWithWhitePieces() {
        val chessBoard: IBoard = createCapablancaChessBoard()

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 0))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(0, 0))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 1))?.color)
        Assert.assertEquals(PieceType.KNIGHT, chessBoard.getPieceByPosition(Position(0, 1))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 2))?.color)
        Assert.assertEquals(PieceType.ARCHBISHOP, chessBoard.getPieceByPosition(Position(0, 2))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 3))?.color)
        Assert.assertEquals(PieceType.BISHOP, chessBoard.getPieceByPosition(Position(0, 3))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 4))?.color)
        Assert.assertEquals(PieceType.QUEEN, chessBoard.getPieceByPosition(Position(0, 4))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 5))?.color)
        Assert.assertEquals(PieceType.KING, chessBoard.getPieceByPosition(Position(0, 5))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 6))?.color)
        Assert.assertEquals(PieceType.BISHOP, chessBoard.getPieceByPosition(Position(0, 6))?.type)

        Assert.assertEquals(Color.WHITE, chessBoard.getPieceByPosition(Position(0, 7))?.color)
        Assert.assertEquals(PieceType.CHANCELLOR, chessBoard.getPieceByPosition(Position(0, 7))?.type)
    }

    @Test
    fun createCapablancaBoardWithBoardPieces(){
        val chessBoard: IBoard = createCapablancaChessBoard()

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 9))?.color)
        Assert.assertEquals(PieceType.ROOK, chessBoard.getPieceByPosition(Position(9, 9))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 8))?.color)
        Assert.assertEquals(PieceType.KNIGHT, chessBoard.getPieceByPosition(Position(9, 8))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 2))?.color)
        Assert.assertEquals(PieceType.ARCHBISHOP, chessBoard.getPieceByPosition(Position(9, 2))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 3))?.color)
        Assert.assertEquals(PieceType.BISHOP, chessBoard.getPieceByPosition(Position(9, 3))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 4))?.color)
        Assert.assertEquals(PieceType.QUEEN, chessBoard.getPieceByPosition(Position(9, 4))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 5))?.color)
        Assert.assertEquals(PieceType.KING, chessBoard.getPieceByPosition(Position(9, 5))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 6))?.color)
        Assert.assertEquals(PieceType.BISHOP, chessBoard.getPieceByPosition(Position(9, 6))?.type)

        Assert.assertEquals(Color.BLACK, chessBoard.getPieceByPosition(Position(9, 7))?.color)
        Assert.assertEquals(PieceType.CHANCELLOR, chessBoard.getPieceByPosition(Position(9, 7))?.type)

    }

}