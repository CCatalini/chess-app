package chess.board

import edu.austral.dissis.chess.factory.pieceInit.PawnInitializer
import edu.austral.dissis.chess.factory.pieceInit.RookInitializer
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import org.junit.Assert
import org.junit.Test

class BoardTest {

    @Test
    fun updateBoard() {
        val initialBoard = Board(8, 8, mapOf(Position(0, 0) to RookInitializer().initialize(Color.WHITE)))
        val movement = Movement(Position(0, 0), Position(1, 1))
        val updatedBoard = initialBoard.update(movement)

        Assert.assertNull(updatedBoard.getPieceByPosition(Position(0, 0)))
        Assert.assertEquals(PieceType.ROOK, updatedBoard.getPieceByPosition(Position(1, 1))?.type)
    }


    @Test
    fun updateBoardWithPawn() {
        val initialBoard = Board(8, 8, mapOf(Position(1, 1) to PawnInitializer().initialize(Color.WHITE)))
        val movement = Movement(Position(1, 1), Position(2, 1))
        val updatedBoard = initialBoard.update(movement)

        Assert.assertNull(updatedBoard.getPieceByPosition(Position(1, 1)))
        Assert.assertEquals(PieceType.PAWN, updatedBoard.getPieceByPosition(Position(2, 1))?.type)
    }

}