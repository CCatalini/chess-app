package chess.game

import chess.board.*
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState

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
