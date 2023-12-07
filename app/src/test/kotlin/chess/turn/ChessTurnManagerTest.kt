package chess.turn

import edu.austral.dissis.chess.factory.createChessNormalGame
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.TurnValidator
import edu.austral.dissis.common.validator.ValidatorResponse
import org.junit.jupiter.api.Test

class ChessTurnManagerTest {

    private val turnManager: TurnValidator = ChessTurnValidator(Color.WHITE)
    private val gameState: IGameState = createChessNormalGame()

    @Test
    fun `initialize with the correct color`() {
        assert(turnManager.getTurn() == Color.WHITE)
    }

    @Test
    fun `change turn`() {
        val newTurnManager = turnManager.nextTurn(gameState)
        assert(newTurnManager.getTurn() == Color.BLACK)
    }

    @Test
    fun `change turn twice`() {
        val newTurnManager = turnManager.nextTurn(gameState).nextTurn(gameState)
        assert(newTurnManager.getTurn() == Color.WHITE)
    }

    @Test
    fun `validates turn (CORRECT)`() {
        assert(turnManager.validateTurn(Movement(Position(1, 0), Position(3, 0)), gameState) is ValidatorResponse.ValidatorResultValid)
    }

    @Test
    fun `validates turn (INCORRECT)`() {
        assert(turnManager.validateTurn(Movement(Position(6, 0), Position(3, 0)), gameState) is ValidatorResponse.ValidatorResultInvalid)
    }
}