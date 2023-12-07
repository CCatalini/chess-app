package checkers.move

import edu.austral.dissis.checkers.factory.createCheckersNormalGame
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import org.junit.Test

class ManMoveTest {

    private val initialGameState: IGameState = createCheckersNormalGame()

    @Test
    fun `test simple move`() {
        val afterMove = initialGameState.movePiece(Movement(Position(1, 2), Position(2, 3)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(2, 3)) != null)
    }

    @Test
    fun `test simple move 3`() {
        val afterMove = initialGameState.movePiece(Movement(Position(1, 2), Position(2, 3)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(2, 3))!!.color == initialGameState.getCurrentTurn())
    }

    @Test
    fun `test invalid move`() {
        val afterMove = initialGameState.movePiece(Movement(Position(1, 2), Position(2, 4)))
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(2, 4)) == null)
    }

    @Test
    fun `eat`() {
        val afterMove = initialGameState.movePiece(Movement(Position(2, 1), Position(3, 2))).movePiece(Movement(Position(5, 4), Position(4, 3))).movePiece(
            Movement(Position(3, 2), Position(5, 4))
        )
        assert(afterMove.getCurrentBoard().getPieceByPosition(Position(3, 2)) == null)
    }
}