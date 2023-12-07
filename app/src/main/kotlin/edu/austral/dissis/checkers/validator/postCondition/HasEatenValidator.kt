package edu.austral.dissis.checkers.validator.postCondition

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.postCondition.PostConditionResult
import edu.austral.dissis.chess.validator.postCondition.PostConditionValidator
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState

class HasEatenValidator : PostConditionValidator {

    override fun validate(gameState: IGameState, updatedBoard: IBoard): PostConditionResult {
        val previousBoard = gameState.getCurrentBoard()
        val latestMovement = getLatestMovement(previousBoard, updatedBoard)

        if ( !isEatingMovement(latestMovement) )
            return PostConditionResult.ResultInvalid("No se ha comido ninguna pieza")

        val board = updateEatenBoard(updatedBoard, latestMovement)

        return PostConditionResult.ResultValid(board)
    }


    // agarra el último movimiento que se hizo comparando los tableros antes de mover y después de mover
    private fun getLatestMovement(previousBoard: IBoard, updatedBoard: IBoard): Movement {
        //posiciones ocupadas de los tableros
        val previousBoardPieces : List<Position> = previousBoard.getOccupiedPositions()
        val updatedBoardPieces : List<Position> = updatedBoard.getOccupiedPositions()

        val positionTo = getPositionTo(previousBoardPieces, updatedBoardPieces)
        val piece = updatedBoard.getPieceByPosition(positionTo)

        val positionFrom = previousBoard.getPositionByPiece(piece!!)
        return Movement(positionFrom!!, positionTo)
    }

    private fun getPositionTo( previousBoardPieces : List<Position>, updatedBoardPieces: List<Position>): Position {
        return updatedBoardPieces.first { !previousBoardPieces.contains(it) }
    }

    private fun isEatingMovement(latestMovement: Movement): Boolean {
        return kotlin.math.abs(latestMovement.from.row - latestMovement.to.row) == 2
    }

    private fun updateEatenBoard(updatedBoard: IBoard, latestMovement: Movement): IBoard {
        val positionToRemove = getEatenPosition(latestMovement)
        return updatedBoard.removePieceByPosition(positionToRemove)
    }

    private fun getEatenPosition(latestMovement: Movement): Position {
        // para agarrar la posición de la pieza que hay que sacar
        val row = latestMovement.from.row + getRowSense(latestMovement)
        val column = latestMovement.from.column + getColumnSense(latestMovement)
        return Position(row, column)
    }

    private fun getRowSense(latestMovement: Movement): Int {
        return when {
            latestMovement.from.row < latestMovement.to.row -> 1
            latestMovement.from.row > latestMovement.to.row -> -1
            else -> 0
        }
    }

    private fun getColumnSense(latestMovement: Movement): Int {
        return when {
            latestMovement.from.column < latestMovement.to.column -> 1
            latestMovement.from.column > latestMovement.to.column -> -1
            else -> 0
        }
    }




}