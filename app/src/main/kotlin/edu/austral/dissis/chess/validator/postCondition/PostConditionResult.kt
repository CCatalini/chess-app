package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.validator.ValidatorResponse

sealed interface PostConditionResult {

    data class ResultValid(val board: IBoard) : PostConditionResult
    data class ResultInvalid(val message: String) : PostConditionResult
}