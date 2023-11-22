package edu.austral.dissis.chess.validator.winCondition

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.validator.postCondition.CheckValidator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.WinCondition

class CheckMateValidator : WinCondition {

    private val checkValidator = CheckValidator()

    override fun isWin(gameState: IGameState): Boolean {
        val enemyPositions = getAllEnemyPositions(gameState)


        for (position in enemyPositions) {
            //recorre todas las piezas enemigas y obtiene todos los movimientos válidos que pueden hacer
            val validMoves : List<Movement> = findAllValidMoves(position, gameState)

            for (movement in validMoves) {
                //vemos si alguno de los movimientos no deja en jaque
                if (moveIsNotCheck(movement, gameState)) {
                    return false
                }
            }
        }

        return true

    }


    private fun getAllEnemyPositions(gameState: IGameState) : List<Position> {
        val board : IBoard = gameState.getCurrentBoard()
        val enemyPositions = mutableListOf<Position>()
        val currentPlayer = gameState.getCurrentTurn()
        val enemy: Color = if (currentPlayer == Color.WHITE) {
            Color.BLACK
        } else {
            Color.WHITE
        }

        for(position in board.getOccupiedPositions()){
            val piece = board.getPieceByPosition(position)
            if (piece != null && piece.getColor() == enemy) {
                enemyPositions.add(position)
            }
        }
        return enemyPositions
    }

    private fun findAllValidMoves(position: Position, gameState: IGameState) : List<Movement> {
        val board: IBoard = gameState.getCurrentBoard()
        val piece: Piece = board.getPieceByPosition(position) ?: throw NoSuchElementException("No está la pieza, capo")
        val validMoves = mutableListOf<Movement>()

        for (row in 0 until board.getWidth()) {
            for (column in 0 until board.getHeight()) {
                val positionTo = Position(row, column)
                val movement = Movement(position, positionTo)
                val validator = piece.validateMove(movement, gameState)

                if (validator is ValidatorResponse.ValidatorResultValid) {
                    validMoves.add(movement)
                }
            }
        }
        return validMoves
    }

    private fun moveIsNotCheck(movement: Movement, gameState: IGameState) : Boolean{
        val nextGameState : IGameState = gameState.movePiece(movement)
        return !checkValidator.validate(nextGameState)
    }

}