package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator
import edu.austral.dissis.chess.validator.ValidatorResponse

/** Clase para verificar el límite de posiciones que una pieza se puede mover en linea recta */
class LimitStraightMoveValidator(private val limit: Int): Validator {

    override fun validate(movement: Movement, gameState: GameState): ValidatorResponse {
        val fromX = movement.from.row
        val toX = movement.to.row
        val deltaX = fromX - toX

        return if   (deltaX <= limit) ValidatorResponse.ValidatorResultValid("OK")
               else ValidatorResponse.ValidatorResultInvalid("No respeta el limite establecido")
    }

}