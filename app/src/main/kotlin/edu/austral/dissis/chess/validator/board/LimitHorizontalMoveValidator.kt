package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

class LimitHorizontalMoveValidator(private val limit: Int) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val fromY = movement.from.column
        val toY = movement.to.column
        val deltaX = fromY - toY

        return  if (deltaX <= limit) ValidatorResponse.ValidatorResultValid("OK")
                else ValidatorResponse.ValidatorResultInvalid("No respeta el límite establecido")
    }
}