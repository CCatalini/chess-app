package edu.austral.dissis.common.validator.board

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement

/** Clase para validar que el movimiento caiga dentro del tablero. */
class LegalPositionValidator : edu.austral.dissis.common.validator.Validator {

    override fun validate(movement: Movement, gameState: IGameState): edu.austral.dissis.common.validator.ValidatorResponse {

        val height : Int = gameState.getCurrentBoard().getHeight()
        val width : Int = gameState.getCurrentBoard().getWidth()

        return  if (movement.to.column < height && movement.to.row < width
                    && movement.to.column >= 0 && movement.to.row >= 0)
                     edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid("OK")
                else edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultInvalid("Te fuiste del tablero reina")

    }
}