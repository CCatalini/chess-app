package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.validator.ValidatorResponse

/** Para validar que el camino horizontal esta vacio */
class HorizontalEmptyPathValidator : edu.austral.dissis.common.validator.Validator {
    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        if (movement.from.row != movement.to.row) return ValidatorResponse.ValidatorResultInvalid("No es un movimiento horizontal.")

        val positions: Board = gameState.getCurrentBoard() as Board

        val fromX = movement.from.row
        val fromY = movement.from.column
        val toY = movement.to.column

        return isEmptyPath(fromX, fromY, toY, positions)
    }



    private fun isEmptyPath(fromX: Int, fromY: Int, toY: Int, positions: Board): ValidatorResponse {
        val typeMove =
            if (fromY < toY)     "right movement"
            else                 "left movement"

        return if (typeMove == "right movement")     isEmptyPathRightMovement(fromX, fromY, toY, positions)
        else                                         isEmptyPathLeftMovement(fromX, fromY, toY, positions)
    }

    private fun isEmptyPathRightMovement(fromX: Int, fromY: Int, toY: Int, positions: Board): ValidatorResponse {
        for (y in fromY + 1..<toY) {
            val positionToCheck = Position(fromX, y)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }

    private fun isEmptyPathLeftMovement(fromX: Int, fromY: Int, toY: Int, positions: Board): ValidatorResponse {
        for (y in fromY - 1 downTo toY +1) {
            val positionToCheck = Position(fromX, y)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }

}



