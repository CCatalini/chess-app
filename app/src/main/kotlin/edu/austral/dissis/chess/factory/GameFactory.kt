package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.Color
import edu.austral.dissis.chess.validator.postCondition.IsNotCheckValidator
import edu.austral.dissis.chess.validator.postCondition.PromotionValidator
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator


fun createChessNormalGame(): IGameState {
    val board = createClassicChessBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(IsNotCheckValidator()),
        listOf(PromotionValidator())
    )
}

fun createChessCapablancaGame(): IGameState {
    val board = createCapablancaChessBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(IsNotCheckValidator()),
        listOf(PromotionValidator())
    )
}