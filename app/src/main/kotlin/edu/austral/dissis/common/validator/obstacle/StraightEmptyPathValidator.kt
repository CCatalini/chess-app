package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement

/** Para validar que el camino frontal esta vacio */
class StraightEmptyPathValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        val positions : Board = gameState.getCurrentBoard() as Board

        val fromX = movement.from.row
        val toX = movement.to.row
        val toY = movement.to.column

        for (x in fromX + 1..toX) {
            val positionToCheck = Position(x, toY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }

        return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
    }
}