package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid

//para ver si mis piezas me dejan en check
class CheckValidator {

    /*
    *
    * Revisa si esta en check el rey del color que se le pasa
    *
    * */
    fun inCheck(gameState: IGameState, kingColor: Color): Boolean {
        val board = gameState.getCurrentBoard()
        val kingPosition = getKingPosition(board, kingColor) ?: return true
        val enemyPositions = getEnemyPositions(board, kingColor)
        for(enemyPosition in enemyPositions) {
            if (pieceAttacksKing(gameState, enemyPosition, kingPosition)) {
                return true
            }
        }
        return false
    }

    private fun getKingPosition(board: IBoard, kingColor: Color): Position? {
        board.getOccupiedPositions().forEach {
                coordinate ->
            val piece = board.getPieceByPosition(coordinate)
            if (isKing(piece) && matchesColor(piece, kingColor)) {
                return coordinate
            }
        }
        return null
    }

    private fun isKing(piece: Piece?): Boolean{
        return (piece?.type == PieceType.ChessPieceType.KING)
    }

    private fun matchesColor(piece: Piece?, color: Color): Boolean{
        return (piece?.color == color)
    }

    private fun getEnemyPositions(board: IBoard, kingColor: Color): List<Position> {
        val enemyPositions: MutableList<Position> = mutableListOf()
        board.getOccupiedPositions().forEach {
                coordinate ->
            val piece = board.getPieceByPosition(coordinate)
            if (!matchesColor(piece, kingColor)) {
                enemyPositions.add(coordinate)
            }
        }
        return enemyPositions
    }

    private fun pieceAttacksKing(gameState: IGameState, enemyPosition: Position, kingPosition: Position): Boolean {
        val enemy : Piece = gameState.getCurrentBoard().getPieceByPosition(enemyPosition) ?: return false
        val move : Movement = Movement(enemyPosition, kingPosition)
        return enemy.validateMove(move, gameState) is ValidatorResponse.ValidatorResultValid
    }

}