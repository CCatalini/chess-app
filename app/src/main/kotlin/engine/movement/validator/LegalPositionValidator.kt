package engine.movement.validator

import GameState
import engine.movement.Movement

class LegalPositionValidator : MovementValidator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {

        val height : Int = gameState.getCurrentBoard().getHeight()
        val width : Int = gameState.getCurrentBoard().getWidth()

        return movement.to.column < height && movement.to.row < width
            && movement.to.column >= 0 && movement.to.row >= 0
    }
}