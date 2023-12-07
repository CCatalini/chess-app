package chess.move

import edu.austral.dissis.chess.factory.createChessNormalGame
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.board.Position
import org.junit.Test

class PawnMoveTest {

    private val initialGameState: IGameState = createChessNormalGame()

    @Test
    fun initialMoveTest2Spaces() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(3, 0)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(3, 0)) != null)
    }

    @Test
    fun initialMoveTest1Space() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(2, 0)))
        assert(afterMoveGameState.getCurrentBoard().getPieceByPosition(Position(2, 0)) != null)
    }

    @Test
    fun initialMoveTest3Spaces() {
        val afterMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(4, 0)))
        assert(afterMoveGameState is InvalidMoveGameState)
    }

    @Test
    fun eatRightPiece() {
        val afterFirstMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(3, 0)))
        val afterSecondMoveGameState = afterFirstMoveGameState.movePiece(Movement(Position(6, 1), Position(4, 1)))
        val afterThirdMoveGameState = afterSecondMoveGameState.movePiece(Movement(Position(3, 0), Position(4, 1)))
        assert(afterThirdMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 1)) != null)
        assert(afterThirdMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 1))!!.color == initialGameState.getCurrentTurn())
    }

    @Test
    fun obstacleFrontMovement() {
        val afterFirstMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(3, 0)))
        val afterSecondMoveGameState = afterFirstMoveGameState.movePiece(Movement(Position(6, 0), Position(4, 0)))
        val afterThirdMoveGameState = afterSecondMoveGameState.movePiece(Movement(Position(3, 0), Position(4, 0)))
        assert(afterThirdMoveGameState is InvalidMoveGameState)
    }

    @Test
    fun eatLeftPiece(){
        val afterFirstMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(3, 0)))
        val afterSecondMoveGameState = afterFirstMoveGameState.movePiece(Movement(Position(6, 1), Position(4, 1)))
        val afterThirdMoveGameState = afterSecondMoveGameState.movePiece(Movement(Position(3, 0), Position(4, 1)))
        assert(afterThirdMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 1)) != null)
        assert(afterThirdMoveGameState.getCurrentBoard().getPieceByPosition(Position(4, 1))!!.color == initialGameState.getCurrentTurn())
    }

    @Test
    fun invalidHorizontalMove(){
        val afterFirstMoveGameState = initialGameState.movePiece(Movement(Position(1, 0), Position(3, 0)))
        val afterSecondMoveGameState = afterFirstMoveGameState.movePiece(Movement(Position(6, 1), Position(4, 1)))
        val afterThirdMoveGameState = afterSecondMoveGameState.movePiece(Movement(Position(3, 0), Position(3, 1)))
        assert(afterThirdMoveGameState is InvalidMoveGameState)
    }



}
