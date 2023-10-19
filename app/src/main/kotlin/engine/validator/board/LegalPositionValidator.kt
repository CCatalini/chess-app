package engine.validator.board

import GameState
import engine.movement.Movement
import engine.validator.Validator

class LegalPositionValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {

        val height : Int = gameState.getCurrentBoard().getHeight()
        val width : Int = gameState.getCurrentBoard().getWidth()

        return movement.to.column < height && movement.to.row < width
            && movement.to.column >= 0 && movement.to.row >= 0
    }
}