package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse
import kotlin.math.abs

/** */
class LimitDiagonalMoveValidator (private val limit: Int) : Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val fromX = movement.from.row
        val fromY = movement.from.column
        val toX = movement.to.row
        val toY = movement.to.column
        val deltaX = fromX - toX
        val deltaY = fromY - toY

        return if (abs(deltaX) <= limit && abs(deltaY) <= limit && abs(deltaX) == abs(deltaY)) {
            ValidatorResponse.ValidatorResultValid("OK")
        } else {
            ValidatorResponse.ValidatorResultInvalid("No respeta el límite establecido")
        }
    }
}