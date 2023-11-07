package edu.austral.dissis.chess.validator.direction

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

class KnightMoveValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        return if  (
            (movement.from.row == movement.to.row + 1 && movement.from.column == movement.to.column + 2) ||
            (movement.from.row == movement.to.row + 2 && movement.from.column == movement.to.column + 1) ||
            (movement.from.row == movement.to.row + 1 && movement.from.column == movement.to.column - 2) ||
            (movement.from.row == movement.to.row + 2 && movement.from.column == movement.to.column - 1) ||
            (movement.from.row == movement.to.row - 1 && movement.from.column == movement.to.column + 2) ||
            (movement.from.row == movement.to.row - 2 && movement.from.column == movement.to.column + 1) ||
            (movement.from.row == movement.to.row - 1 && movement.from.column == movement.to.column - 2) ||
            (movement.from.row == movement.to.row - 2 && movement.from.column == movement.to.column - 1)
        ) {
            ValidatorResponse.ValidatorResultValid("OK")
        }else{
            ValidatorResponse.ValidatorResultInvalid("no respeta el movimiento del caballo")
        }
    }

}
