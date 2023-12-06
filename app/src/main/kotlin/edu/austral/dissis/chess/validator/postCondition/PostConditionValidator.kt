package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.board.IBoard

interface PostConditionValidator {

    fun validate(gameState: IGameState, updatedBoard: IBoard): PostConditionResult
}