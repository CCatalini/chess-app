package edu.austral.dissis.checkers.factory

import edu.austral.dissis.checkers.factory.pieceInit.QueenInitializer
import edu.austral.dissis.checkers.validator.postCondition.HasEatenValidator
import edu.austral.dissis.checkers.validator.turn.CheckersTurnManager
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.postCondition.PromotionValidator
import edu.austral.dissis.common.validator.winCondition.ExtinctionCondition

//TODO implementar
fun createCheckersNormalGame(): IGameState {
    val board = createCheckersBoard()
    return GameState(
        listOf(board),
        ExtinctionCondition(),
        CheckersTurnManager(Color.WHITE, listOf()),
        listOf(),
        listOf(HasEatenValidator(), PromotionValidator(QueenInitializer()))
    )
}
