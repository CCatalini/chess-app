package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

//usamos el checkValidator porque es más fácil negarlo que checkear si en todas las jugadas no queda en jaque
//preCondition del game
class IsNotCheckValidator : Validator {

    private val checkValidator = CheckValidator()

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {
        val newGameState = simulateMove(movement, gameState) //simulo el movimiento
        val kingColor = gameState.getCurrentTurn()
        return if (checkValidator.inCheck(newGameState, kingColor)) { //me fijo si me deja al actual turno en check
            ValidatorResponse.ValidatorResultInvalid("Regla numero 1: no te regales (check)")
        } else {
            ValidatorResponse.ValidatorResultValid("You are not in check")
        }
    }


    private fun simulateMove(movement: Movement, gameState: IGameState): IGameState {
        val newBoard = gameState.getCurrentBoard().update(movement)
        val newBoards = gameState.getBoards().toMutableList()
        newBoards.add(newBoard)
        return GameState(
            newBoards,
            gameState.getWinCondition(),
            gameState.getTurnManager(),
            gameState.getListPreConditions(),
            gameState.getListPostConditions()
        )
    }
}