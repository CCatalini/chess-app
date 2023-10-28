package edu.austral.dissis.chess.validator.obstacle

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.board.BoardImpl
import edu.austral.dissis.chess.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

class DiagonalEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val positions: BoardImpl = gameState.getCurrentBoard() as BoardImpl

        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column
        var currentX = fromX + 1
        var currentY = fromY + 1

        while (currentX < toX && currentY < toY) {
            val positionToCheck = Position(currentX, currentY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
            currentX++
            currentY++
        }

        return ValidatorResponse.ValidatorResultValid("OK")
    }

}