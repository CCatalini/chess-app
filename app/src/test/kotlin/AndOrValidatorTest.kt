import engine.GameStateImpl
import engine.board.BoardImpl
import engine.board.Position
import engine.movement.Movement
import engine.piece.Color
import engine.piece.Pawn
import engine.validator.*
import engine.validator.board.LegalPositionValidator
import engine.validator.orientation.StraightValidator
import org.junit.jupiter.api.Test

internal class AndOrValidatorTest {

    //test de santi para que vea como funciona el andValidator para los validadores
    @Test
    fun testAndValidator() {
        val validator : Validator = AndValidator(
            listOf(
                StraightValidator(1, 1),
                LegalPositionValidator()
            ))

        val gameState: GameState = GameStateImpl(
            listOf(
                BoardImpl(8,8, mapOf()) ))

        val movement : Movement = Movement( Position(0,0), Position(9,0) )

        println(validator.validate(movement, gameState))
    }

    @Test
    fun testOrValidator() {
        val validator : Validator = OrValidator(
            listOf(
                StraightValidator(1, 1),
                LegalPositionValidator()
            ))

        val gameState: GameState = GameStateImpl(
            listOf(
                BoardImpl(8,8, mapOf()) ))

        val movement : Movement = Movement( Position(0,0), Position(9,0) )

        println(validator.validate(movement, gameState))
    }




    @Test
    fun cositas(){
        val gameState: GameState = GameStateImpl(
            listOf(
                BoardImpl(8, 8, mapOf(
                    Position(0, 0) to Pawn("1", Color.BLACK, listOf())
                ))
            )
        )

        println(gameState.getCurrentBoard().getPieceByPosition(Position(0,0))!!.getId())

    }



}