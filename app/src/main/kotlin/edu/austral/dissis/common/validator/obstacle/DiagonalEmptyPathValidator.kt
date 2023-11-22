package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import kotlin.math.abs

class DiagonalEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        if(abs(movement.from.row - movement.to.row) != abs(movement.from.column - movement.to.column)){
            return ValidatorResponse.ValidatorResultInvalid("No es un movimiento diagonal")
        }

        var currentCoordinate = movement.from

        while (currentCoordinate.row != movement.to.row && currentCoordinate.column != movement.to.column){
            currentCoordinate =
                if (currentCoordinate.row < movement.to.row && currentCoordinate.column < movement.to.column){
                    Position(currentCoordinate.row + 1, currentCoordinate.column + 1)
                }else if (currentCoordinate.row < movement.to.row){
                    Position(currentCoordinate.row + 1, currentCoordinate.column - 1)
                }else if (currentCoordinate.column < movement.to.column){
                    Position(currentCoordinate.row - 1, currentCoordinate.column + 1)
                }else {
                    Position(currentCoordinate.row - 1, currentCoordinate.column - 1)
                }
            if (currentCoordinate.row != movement.to.row && currentCoordinate.column != movement.to.column && gameState.getCurrentBoard().getPieceByPosition(currentCoordinate) != null){
                return ValidatorResponse.ValidatorResultInvalid("Hay piezas en el camino")
            }
        }

        return ValidatorResponse.ValidatorResultValid("OK")
    }

}

