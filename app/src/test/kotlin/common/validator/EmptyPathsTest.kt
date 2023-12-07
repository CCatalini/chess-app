package common.validator

import edu.austral.dissis.chess.factory.pieceInit.KnightInitializer
import edu.austral.dissis.chess.factory.pieceInit.RookInitializer
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.obstacle.DiagonalEmptyPathValidator
import org.junit.Assert.assertEquals
import org.junit.Test

class EmptyPathsTest {

    @Test
    fun testDiagonalEmptyPathValid() {
        val gameState = GameState(listOf( Board(8,8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf(),
            listOf())
        val validator = DiagonalEmptyPathValidator()

        val from = Position(2, 2)
        val to = Position(5, 5)
        val movement = Movement(from, to)

        val result = validator.validate(movement, gameState)

        assertEquals(ValidatorResponse.ValidatorResultValid("OK"), result)
    }

    @Test
    fun testDiagonalNotEmptyPathInvalid() {

        val map: Map<Position, Piece> = mutableMapOf(
            Position(2, 2) to RookInitializer().initialize(Color.WHITE),
            Position(3,3) to KnightInitializer().initialize(Color.WHITE)
        )

        val gameState = GameState(listOf( Board(8, 8, map)),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf(),
            listOf())
        val validator = DiagonalEmptyPathValidator()

        val from = Position(2, 2)
        val to = Position(5, 5)
        val movement = Movement(from, to)

        val result = validator.validate(movement, gameState)

        assertEquals(ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino"), result)
    }

}