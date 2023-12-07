package checkers.move

import edu.austral.dissis.checkers.factory.createCheckersQueenTestGame
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import org.junit.Test

class QueenMoveTest {

    private val initialGameState: IGameState = createCheckersQueenTestGame()

    @Test
    fun `test simple move`() {
        val afterMove = initialGameState.movePiece(Movement(Position(2, 2), Position(3, 3)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(3, 3)) != null)
    }

    @Test
    fun `test simple move 3`() {
        val afterMove = initialGameState.movePiece(Movement(Position(2, 2), Position(1, 3)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(1, 3))!!.color == initialGameState.getCurrentTurn())
    }

    @Test
    fun `test valid move`() {
        val afterMove = initialGameState.movePiece(Movement(Position(2, 2), Position(3, 1)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(3, 1)) != null)
    }

    @Test
    fun `eat`() {
        val afterMove = initialGameState.movePiece(Movement(Position(2, 2), Position(0, 0)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(1, 1)) == null)
    }

}