package chess.winCondition

import edu.austral.dissis.chess.factory.createChessNormalGame
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.winCondition.WinCondition
import org.junit.jupiter.api.Test

class CheckMateTest {

    private val initialGameState: IGameState = createChessNormalGame()
    private val checkMateValidator: WinCondition = CheckMateValidator()

    @Test
    fun notFinishedGame() {
        assert(!checkMateValidator.isWin(initialGameState))
    }

    @Test
    fun finishedGame() {
        val finishedGame = initialGameState.movePiece(Movement(Position(1, 4), Position(2, 4)))
            .movePiece(Movement(Position(6, 5), Position(5, 5)))
            .movePiece(Movement(Position(1, 0), Position(2, 0)))
            .movePiece(Movement(Position(6, 6), Position(4, 6)))
            .movePiece(Movement(Position(0, 3), Position(4, 7)))
        assert(checkMateValidator.isWin(finishedGame))
    }

}