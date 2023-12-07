package edu.austral.dissis.common.validator.obstacle

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class EmptyDestinationValidator : Validator {
    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val board = gameState.getCurrentBoard()

        return if (board.getPieceByPosition(movement.to) == null) ValidatorResponse.ValidatorResultValid("OK")
        else ValidatorResponse.ValidatorResultInvalid("Hay una pieza en la posicion de destino")
    }
}