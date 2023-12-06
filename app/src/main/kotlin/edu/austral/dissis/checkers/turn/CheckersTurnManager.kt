package edu.austral.dissis.checkers.turn

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.ValidatorResponse

class CheckersTurnManager(private val color: Color) : TurnValidator {
    override fun getTurn(): Color {
        return color
    }

    override fun nextTurn(): TurnValidator {
        return this
    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        return ValidatorResponse.ValidatorResultValid("nashei")
    }

}
