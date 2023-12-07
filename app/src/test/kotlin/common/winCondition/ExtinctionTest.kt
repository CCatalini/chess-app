package common.winCondition

import edu.austral.dissis.checkers.factory.createCheckersNormalGame
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.winCondition.ExtinctionCondition
import edu.austral.dissis.common.validator.winCondition.WinCondition
import org.junit.Test

class ExtinctionTest {
    private val initialGameState: IGameState = createCheckersNormalGame()
    private val extinctionValidator: WinCondition = ExtinctionCondition()

    @Test
    fun notFinishedGame() {
        assert(!extinctionValidator.isWin(initialGameState))
    }
/*
    @Test
    fun finishedGame() {
        assert(!extinctionValidator.isWin(initialGameState))

        val finishedGame = initialGameState
            .movePiece(Movement(Position(2, 3), Position(3, 4)))
            .movePiece(Movement(Position(5, 2), Position(4, 3)))
            .movePiece(Movement(Position(2, 5), Position(3, 6)))
            .movePiece(Movement(Position(5, 4), Position(4, 5)))
            .movePiece(Movement(Position(2, 7), Position(3, 6)))
            .movePiece(Movement(Position(5, 6), Position(4, 7)))
            .movePiece(Movement(Position(2, 1), Position(3, 0)))
            .movePiece(Movement(Position(5, 6), Position(4, 7)))
            .movePiece(Movement(Position(1, 0), Position(2, 1)))
            .movePiece(Movement(Position(6, 5), Position(4, 3)))
            .movePiece(Movement(Position(2, 1), Position(3, 0)))
            .movePiece(Movement(Position(6, 7), Position(5, 6)))
            .movePiece(Movement(Position(3, 0), Position(4, 1)))
            .movePiece(Movement(Position(6, 3), Position(5, 4)))
            .movePiece(Movement(Position(4, 1), Position(5, 0)))
            .movePiece(Movement(Position(3, 6), Position(4, 7)))
            .movePiece(Movement(Position(6, 1), Position(5, 0)))

        assert(extinctionValidator.isWin(finishedGame))
    }

 */




}