import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.obstacle.StraightEmptyPathValidator
import org.junit.jupiter.api.Test

internal class ObstacleValidatorTest {

    @Test
    fun testValidateEmptyPath() {
        val emptyBoard = Board(8, 8, emptyMap())
        val validator = StraightEmptyPathValidator()
        val gameState: IGameState = GameState( listOf( emptyBoard ))

        val movement1 = Movement(Position(2, 3), Position(2, 7))
//        Assert.assertTrue(validator.run { validate(movement1, gameState) })


    }
}