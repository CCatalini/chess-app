package chess.move

import chess.game.createBishopTestGame
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.FinishGameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import org.junit.jupiter.api.Test

class BishopMoveTest {

    private val initialGameState: IGameState = createBishopTestGame()

    @Test
    fun moveUpRightObstacle() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(6, 6)))
        assert(afterMoveGameState is InvalidMoveGameState)
    }

    @Test
    fun moveUpRight() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(4, 4)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 4)) != null)
    }

    @Test
    fun moveUpLeft() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(4, 2)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 2)) != null)
    }

    @Test
    fun moveDownRight() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(2, 4)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(2, 4)) != null)
    }

    @Test
    fun moveDownLeft() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(2, 2)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(2, 2)) != null)
    }

    @Test
    fun eat() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(4, 4)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 4)) != null)
        assert(afterMoveGameState is FinishGameState) //se comio todas las piezas
    }

}