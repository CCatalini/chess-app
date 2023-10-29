import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.GameStateImpl
import edu.austral.dissis.chess.validator.OrValidator
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.AndValidator
import edu.austral.dissis.chess.validator.board.LegalPositionValidator
import edu.austral.dissis.chess.validator.direction.StraightValidator
import org.junit.jupiter.api.Test

internal class AndOrValidatorTest {

    //test de santi para que vea como funciona el andValidator para los validadores
    @Test
    fun testAndValidator() {
        val validator : Validator = AndValidator(
            listOf(
                StraightValidator(),
                LegalPositionValidator()
            ))

        val gameState: GameState = GameStateImpl(
            listOf(
                Board(8,8, mapOf()) ))

        val movement : Movement = Movement( Position(0,0), Position(9,0) )

        println(validator.validate(movement, gameState))
    }

    @Test
    fun testOrValidator() {
        val validator : Validator = OrValidator(
            listOf(
                StraightValidator( ),
                LegalPositionValidator()
            ))

        val gameState: GameState = GameStateImpl(
            listOf(
                Board(8,8, mapOf()) ))

        val movement : Movement = Movement( Position(0,0), Position(9,0) )

        println(validator.validate(movement, gameState))
    }



/*
    @Test
    fun cositas(){
        val gameState: GameState = GameStateImpl(
            listOf(
                BoardImpl(8, 8, mapOf(
                    Position(0, 0)
                ))
            )
        )

        println(gameState.getCurrentBoard().getPieceByPosition(Position(0,0))!!.getId())

    }

 */



}