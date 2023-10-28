package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Clase para validar que el movimiento caiga dentro del tablero. */
class LegalPositionValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {

        val height : Int = gameState.getCurrentBoard().getHeight()
        val width : Int = gameState.getCurrentBoard().getWidth()

        return  if (movement.to.column < height && movement.to.row < width
                    && movement.to.column >= 0 && movement.to.row >= 0)
                     ValidatorResponse.ValidatorResultValid("OK")
                else ValidatorResponse.ValidatorResultInvalid("Te fuiste del tablero reina")

    }
}