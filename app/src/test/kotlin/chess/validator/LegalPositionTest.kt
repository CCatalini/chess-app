package chess.validator

import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.ValidatorResponse
import org.junit.Assert
import org.junit.Test

class LegalPositionTest {

    @Test
    fun validateLegalMove() {
        val validator = LegalPositionValidator()
        val gameState = GameState(listOf( Board(8,8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf(),
            listOf())

        val validMovement = Movement(Position(0, 0), Position(1, 1))

        val result: ValidatorResponse = validator.validate(validMovement, gameState)

        Assert.assertEquals(ValidatorResponse.ValidatorResultValid("OK"), result)
    }

    @Test
    fun validateIlegalMove() {
        val validator = LegalPositionValidator()
        val gameState = GameState(listOf( Board(8,8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            listOf(),
            listOf())

        val validMovement = Movement(Position(0, 0), Position(-1, 1))

        val result: ValidatorResponse = validator.validate(validMovement, gameState)

        Assert.assertEquals(ValidatorResponse.ValidatorResultInvalid("Te fuiste del tablero reina"), result)
    }


}
