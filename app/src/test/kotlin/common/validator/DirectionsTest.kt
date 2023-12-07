package common.validator

import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.HorizontalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import org.junit.Test

internal class DirectionsTest {

    @Test
    fun testStraightValidator() {
        val validator = StraightValidator()

        val gameState: IGameState = GameState(listOf(Board(8, 8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf( validator ),
            listOf())

        val verticalMovement = Movement(Position(0, 0), Position(5, 0))
        assert(validator.validate(verticalMovement, gameState) is ValidatorResponse.ValidatorResultValid)

        // Movimiento horizontal
        val horizontalMovement = Movement(Position(0, 0), Position(0, 5))
        assert(validator.validate(horizontalMovement, gameState) is ValidatorResponse.ValidatorResultInvalid)

    }

    @Test
    fun testHorizontalValidator() {
        val validator = HorizontalValidator()

        val gameState: IGameState = GameState(listOf(Board(8, 8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf( validator ),
            listOf())

        val horizontalMovement = Movement(Position(0, 0), Position(0, 5))
        assert(validator.validate(horizontalMovement, gameState) is ValidatorResponse.ValidatorResultValid)

        val verticalMovement = Movement(Position(0, 0), Position(5, 0))
        assert(validator.validate(verticalMovement, gameState) is ValidatorResponse.ValidatorResultInvalid)
    }

    @Test
    fun testDiagonalValidator() {
        val validator = DiagonalValidator()

        val gameState: IGameState = GameState(listOf(Board(8, 8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf( validator ),
            listOf())

        val diagonalMovement = Movement(Position(0, 0), Position(5, 5))
        assert(validator.validate(diagonalMovement, gameState) is ValidatorResponse.ValidatorResultValid)

        // horizontal invalido
        val horizontalMovement = Movement(Position(0, 0), Position(0, 5))
        assert(validator.validate(horizontalMovement, gameState) is ValidatorResponse.ValidatorResultInvalid)

        // vertical invalido
        val verticalMovement = Movement(Position(0, 0), Position(5, 0))
        assert(validator.validate(verticalMovement, gameState) is ValidatorResponse.ValidatorResultInvalid)
    }
}
