package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.board.Board
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement

class DiagonalEmptyPathValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
        val positions: Board = gameState.getCurrentBoard() as Board

        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column
        var currentX = fromX + 1
        var currentY = fromY + 1

        while (currentX < toX && currentY < toY) {
            val positionToCheck = Position(currentX, currentY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
            currentX++
            currentY++
        }

        return edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
    }

}