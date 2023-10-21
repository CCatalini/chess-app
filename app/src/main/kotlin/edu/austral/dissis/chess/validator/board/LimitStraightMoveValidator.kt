package edu.austral.dissis.chess.validator.board

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator

class LimitStraightMoveValidator(private val limit: Int): Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val fromX = movement.from.row
        val toX = movement.to.row
        val deltaX = fromX - toX

        return deltaX <= limit

    }

}