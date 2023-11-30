package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.game.GameState
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

//usamos el checkValidator porque es más fácil negarlo que checkear si en todas las jugadas no queda en jaque
//preCondition del game
class IsNotCheckValidator : Validator {

    private val checkValidator : CheckValidator = CheckValidator()

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {

        val boardAux : IBoard = gameState.getCurrentBoard().update(movement)
        val gameAuxBoards = gameState.getBoards().toMutableList()
        gameAuxBoards.add(boardAux)
        val gameAux = GameState(gameAuxBoards,
                                    gameState.getWinCondition(),
                                    gameState.getTurnManager(),
                                    gameState.getListPreConditions(),
                                    gameState.getListPostConditions())
        return if ( checkValidator.validate(gameAux) ) {
            ValidatorResponse.ValidatorResultInvalid("Regla numero 1: No te regales, estas quedando en jaque")
        } else {
            ValidatorResponse.ValidatorResultValid("OK")
        }
    }
}