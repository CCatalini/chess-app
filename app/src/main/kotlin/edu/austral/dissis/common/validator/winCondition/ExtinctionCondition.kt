package edu.austral.dissis.common.validator.winCondition

import edu.austral.dissis.common.game.IGameState

// para validar que solo queden piezas de un color
class ExtinctionCondition : WinCondition {

    override fun isWin(gameState: IGameState): Boolean {
        val color = gameState.getCurrentTurn()
        // si todas las piezas son del mismo color, gana
        return gameState.getCurrentBoard().getPieces().all { it.color == color }
    }
}