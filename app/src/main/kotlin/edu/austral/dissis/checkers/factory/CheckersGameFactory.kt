package edu.austral.dissis.checkers.factory

import edu.austral.dissis.checkers.turn.CheckersTurnManager
import edu.austral.dissis.checkers.validator.winCondition.EatAllEnemyPiecesValidator
import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.Color

//TODO implementar
fun createCheckersNormalGame(): IGameState {
    val board = createCheckersBoard()
    return GameState(
        listOf(board),
        EatAllEnemyPiecesValidator(),
        CheckersTurnManager(Color.WHITE),
        listOf(),
        listOf()
    )
}
