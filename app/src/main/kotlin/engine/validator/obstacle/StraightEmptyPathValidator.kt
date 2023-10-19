package engine.validator.obstacle

import GameState
import engine.board.BoardImpl
import engine.board.Position
import engine.movement.Movement
import engine.validator.Validator

/** Para validar que el camino frontal esta vacio */
class StraightEmptyPathValidator : Validator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {
        val positions : BoardImpl = gameState.getCurrentBoard() as BoardImpl

        val fromX = movement.from.row
        val toX = movement.to.row
        val toY = movement.to.column

        for (x in fromX + 1 until toX + 1) {
            val positionToCheck = Position(x, toY)
            if (positions.getPieceByPosition(positionToCheck) != null) {
                return false
            }
        }

        return true
    }
}