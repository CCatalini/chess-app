package edu.austral.dissis.checkers.turn

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.ValidatorResponse

class CheckersTurnManager(white: Color) : TurnValidator {
    override fun getTurn(): Color {
        TODO("Not yet implemented")
    }

    override fun nextTurn(): TurnValidator {
        TODO("Not yet implemented")
    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        TODO("Not yet implemented")
    }

}
