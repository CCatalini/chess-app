package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.ValidatorResponse

/** Para validar que el camino horizontal esta vacio */
class HorizontalEmptyPathValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        if (movement.from.row != movement.to.row) return ValidatorResponse.ValidatorResultInvalid("No es un movimiento horizontal.")

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



