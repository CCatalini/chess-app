package edu.austral.dissis.common.validator.winCondition

import edu.austral.dissis.common.game.IGameState

interface WinCondition {

    fun isWin(gameState: IGameState) : Boolean
}