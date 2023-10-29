package edu.austral.dissis.chess.validator.obstacle

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Para validar que el camino horizontal esta vacio */
class HorizontalEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val positions: Board = gameState.getCurrentBoard() as Board

        val fromX = movement.from.row
        val fromY = movement.from.column
        val toY = movement.to.column

        for (y in fromY + 1 until toY) {
            val positionToCheck = Position(fromX, y)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }

        return ValidatorResponse.ValidatorResultValid("OK")

    }


}



