package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.factory.pieceInit.QueenInitializer
import edu.austral.dissis.chess.validator.postCondition.CastleLeftPostCondition
import edu.austral.dissis.chess.validator.postCondition.CastleRightPostCondition
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.Color
import edu.austral.dissis.chess.validator.postCondition.IsNotCheckValidator
import edu.austral.dissis.common.validator.postCondition.PromotionValidator
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator


fun createChessNormalGame(): IGameState {
    val board = createClassicChessBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(IsNotCheckValidator()),
        listOf(PromotionValidator(QueenInitializer()), CastleRightPostCondition(), CastleLeftPostCondition())
    )
}

fun createChessCapablancaGame(): IGameState {
    val board = createCapablancaChessBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(IsNotCheckValidator()),
        listOf(PromotionValidator(QueenInitializer()))
    )
}

fun createRookTestGame(): IGameState {
    val board = createRookTestBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(),
        listOf()
    )
}

fun createBishopTestGame(): IGameState {
    val board = createBishopTestBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(),
        listOf()
    )
}

fun createKnightTestGame(): IGameState {
    val board = createKnightTestBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(),
        listOf()
    )
}

fun createKingTestGame(): IGameState {
    val board = createKingTestBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(),
        listOf()
    )
}

fun createQueenTestGame(): IGameState {
    val board = createQueenTestBoard()
    return GameState(
        listOf(board),
        CheckMateValidator(),
        ChessTurnValidator(Color.WHITE),
        listOf(),
        listOf()
    )
}
