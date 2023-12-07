package checkers.board

import edu.austral.dissis.checkers.factory.createCheckersBoard
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.PieceType
import org.junit.Assert
import org.junit.Test

class BoardFactoryTest {

    @Test
    fun createBoard() {
        val checkersBoard: IBoard = createCheckersBoard()

        for (i in 0..2) {
            val startColumn =
                if (i % 2 == 0) 1 else 0
            for (j in startColumn..7 step 2) {
                Assert.assertEquals(Color.WHITE, checkersBoard.getPieceByPosition(Position(i, j))?.color)
                Assert.assertEquals(PieceType.PAWN, checkersBoard.getPieceByPosition(Position(i, j))?.type)
            }
        }

        for (i in 5..7) {
            val startColumn =
                if (i % 2 == 0) 1 else 0
            for (j in startColumn..7 step 2) {
                Assert.assertEquals(Color.BLACK, checkersBoard.getPieceByPosition(Position(i, j))?.color)
                Assert.assertEquals(PieceType.PAWN, checkersBoard.getPieceByPosition(Position(i, j))?.type)
            }
        }
    }

}

