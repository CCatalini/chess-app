package edu.austral.dissis.chess.validator.obstacle

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.board.BoardImpl
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Para validar que el camino frontal esta vacio */
class StraightEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val positions : BoardImpl = gameState.getCurrentBoard() as BoardImpl

        val fromX = movement.from.row
        val toX = movement.to.row
        val toY = movement.to.column

        for (x in fromX + 1..toX) {
            val positionToCheck = Position(x, toY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }

        return ValidatorResponse.ValidatorResultValid("OK")
    }
}