import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.GameStateImpl
import edu.austral.dissis.chess.board.BoardImpl
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.obstacle.StraightEmptyPathValidator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ObstacleValidatorTest {

    @Test
    fun testValidateEmptyPath() {
        val emptyBoard = BoardImpl(8, 8, emptyMap())
        val validator = StraightEmptyPathValidator()
        val gameState: GameState = GameStateImpl( listOf( emptyBoard ))

        val movement1 = Movement(Position(2, 3), Position(2, 7))
        Assertions.assertTrue(validator.run { validate(movement1, gameState) })


    }
}