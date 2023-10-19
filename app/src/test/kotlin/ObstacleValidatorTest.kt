import engine.GameStateImpl
import engine.board.BoardImpl
import engine.board.Position
import engine.movement.Movement
import engine.validator.obstacle.StraightEmptyPathValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
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