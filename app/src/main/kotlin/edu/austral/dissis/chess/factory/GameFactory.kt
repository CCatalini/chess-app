package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.validator.postCondition.PromotionValidator
import edu.austral.dissis.chess.validator.turn.ChessTurnValidator
import edu.austral.dissis.chess.validator.winCondition.CheckMateValidator

class GameFactory {

    companion object{
        fun createChessNormalGame(): IGameState {
            val board = BoardFactory.createChessBoard()
            val game = GameState(listOf(board), CheckMateValidator(), ChessTurnValidator(Color.WHITE), listOf(), listOf(PromotionValidator()))
            return game
        }
    }
}