import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import org.junit.jupiter.api.Test

internal class AndOrValidatorTest {

    //test de santi para que vea como funciona el andValidator para los validadores
    @Test
    fun testAndValidator() {
        val validator : edu.austral.dissis.common.validator.Validator =
            edu.austral.dissis.common.validator.composition.AndValidator(
                listOf(
                    edu.austral.dissis.common.validator.direction.StraightValidator(),
                    edu.austral.dissis.common.validator.board.LegalPositionValidator()
                )
            )

        val gameState: IGameState = GameState(
            listOf(
                Board(8,8, mapOf()) ))

        val movement : Movement = Movement( Position(0,0), Position(9,0) )

        println(validator.validate(movement, gameState))
    }

    @Test
    fun testOrValidator() {
        val validator : edu.austral.dissis.common.validator.Validator =
            edu.austral.dissis.common.validator.composition.OrValidator(
                listOf(
                    edu.austral.dissis.common.validator.direction.StraightValidator(),
                    edu.austral.dissis.common.validator.board.LegalPositionValidator()
                )
            )

        val gameState: IGameState = GameState(
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