package chess.validator
import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import org.junit.Test

class AndOrTest {

    @Test
    fun testAndValidator() {
        val validator: List<Validator> = listOf( AndValidator(
            listOf(
                StraightValidator(),
                LegalPositionValidator()
            )
        ))
        val gameState: IGameState = GameState(listOf(Board(8, 8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            validator,
            listOf())

        val movement= Movement(Position(0, 0), Position(9, 0))

        for (i in validator) {
            when (val result = i.validate(movement, gameState)) {
                is ValidatorResponse.ValidatorResultValid -> println(result.message)
                is ValidatorResponse.ValidatorResultInvalid -> println(result.message)
            }
        }


    }

    @Test
    fun testOrValidator() {
        val validator: List<Validator> = listOf( OrValidator(
            listOf(
                StraightValidator(),
                LegalPositionValidator()
            )
        ))

        val gameState: IGameState = GameState(listOf(Board(8, 8, emptyMap())),
            CheckMateValidator(),
            ChessTurnValidator(Color.WHITE),
            validator,
            listOf())

        val movement = Movement(Position(0, 0), Position(9, 0))

        for (i in validator) {
            when (val result = i.validate(movement, gameState)) {
                is ValidatorResponse.ValidatorResultValid -> println(result.message)
                is ValidatorResponse.ValidatorResultInvalid -> println(result.message)
            }
        }
    }
}
