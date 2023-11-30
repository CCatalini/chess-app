package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

/** Para validar que el camino frontal esta vacio */
class StraightEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val positions : Board = gameState.getCurrentBoard() as Board

        val fromX = movement.from.row
        val toX = movement.to.row
        val toY = movement.to.column

        return isEmptyPath(fromX, toX, toY, positions)
    }




    private fun isEmptyPath(fromX: Int, toX: Int, toY: Int, positions: Board): ValidatorResponse {
        val typeMove =
            if( fromX < toX )   "downward movement"
            else                "upward movement"

        return if (typeMove == "downward movement")   isEmptyPathDownwardMovement(fromX, toX, toY, positions)
        else                                          isEmptyPathUpwardMovement(fromX, toX, toY, positions)
    }

    //hacia abajo
    private fun isEmptyPathDownwardMovement(fromX: Int, toX: Int, toY: Int, positions: Board): ValidatorResponse {
        for (x in fromX + 1..<toX) {
            val positionToCheck = Position(x, toY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }

    //hacia arriba
    private fun isEmptyPathUpwardMovement(fromX: Int, toX: Int, toY: Int, positions: Board): ValidatorResponse {
        for (x in fromX - 1 downTo toX +1) {
            val positionToCheck = Position(x, toY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }
        return ValidatorResponse.ValidatorResultValid("OK")
    }

}