package edu.austral.dissis.common.game

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.chess.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.WinCondition

class InvalidMoveGameState (private val gameState: IGameState,
                            val errorMessage: String ) : IGameState {

    override fun getBoards(): List<IBoard> {
        return gameState.getBoards()
    }

    override fun getCurrentBoard(): IBoard {
        return gameState.getCurrentBoard()
    }

    override fun getCurrentTurn(): Color {
        return gameState.getCurrentTurn()
    }

    override fun movePiece(movement: Movement): IGameState {
        return gameState.movePiece(movement)
    }



    override fun getTurnManager(): TurnValidator {
        return gameState.getTurnManager()
    }

    override fun getListPreConditions(): List<Validator> {
        return gameState.getListPreConditions()
    }

    override fun getListPostConditions(): List<PostConditionValidator> {
        return gameState.getListPostConditions()
    }

    override fun getWinCondition(): WinCondition {
        return gameState.getWinCondition()
    }

}