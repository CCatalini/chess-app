package chess.move

import chess.game.createRookTestGame
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.FinishGameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import org.junit.jupiter.api.Test

class RookMoveTest {

    private val initialGameState: IGameState = createRookTestGame()

    @Test
    fun moveUp() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(5, 3)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(5, 3)) != null)
    }

    @Test
    fun moveDown() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(1, 3)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(1, 3)) != null)
    }

    @Test
    fun moveLeft() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(3, 1)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(3, 1)) != null)
    }

    @Test
    fun moveRight() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(3, 4)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(3, 5)) != null)
    }

    @Test
    fun eat() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(3, 5)))
        assert(afterMoveGameState is FinishGameState) //se comio todas las piezas
    }

    @Test
    fun invalidMovement() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(5, 5)))
        assert(afterMoveGameState is InvalidMoveGameState)
    }

    @Test
    fun invalidMovement2() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(4, 4)))
        assert(afterMoveGameState is InvalidMoveGameState)
    }

    @Test
    fun invalidMovement3Obstacle() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(3, 3), Position(3, 7)))
        assert(afterMoveGameState is InvalidMoveGameState)
    }

}
