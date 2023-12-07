package edu.austral.dissis.common.validator.postCondition

import edu.austral.dissis.common.board.IBoard

sealed interface PostConditionResult {

    data class ResultValid(val board: IBoard) : PostConditionResult     //board after post conditions
    data class ResultInvalid(val message: String) : PostConditionResult
}