package edu.austral.dissis.common.validator

import edu.austral.dissis.chess.game.IGameState

interface WinCondition {

    fun isWin(gameState: IGameState) : Boolean
}