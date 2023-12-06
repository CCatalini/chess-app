package edu.austral.dissis.checkers.validator.turn

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.ValidatorResponse

class CheckersTurnValidator(private val current: Color) : TurnValidator {

    override fun getTurn(): Color {
       return current
    }

    override fun nextTurn(): TurnValidator {
        return if (current == Color.WHITE) {
            CheckersTurnValidator(Color.BLACK)
        } else {
            CheckersTurnValidator(Color.WHITE)
        }
    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        TODO("Not yet implemented")
    }
}