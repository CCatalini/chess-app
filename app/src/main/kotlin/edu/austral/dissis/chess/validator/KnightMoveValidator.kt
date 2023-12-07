package edu.austral.dissis.chess.validator

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.movement.Movement

class KnightMoveValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {
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
            edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
        }else{
            edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("no respeta el movimiento del caballo")
        }
    }

}
