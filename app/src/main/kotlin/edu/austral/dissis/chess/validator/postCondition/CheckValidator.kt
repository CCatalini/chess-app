package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.chess.game.IGameState
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

    //recibe un gameState mockeado con MI movimiento y valida si me dejo en check
     fun validate( gameState: IGameState): Boolean {

        val myKingColor: Color = gameState.getCurrentTurn()
        val actualBoard: IBoard = gameState.getCurrentBoard()
        val kingPosition: Position = getKingPosition(actualBoard, myKingColor) ?: throw NoSuchElementException("No esta el rey capo")
        val enemyPositions: List<Position> = getEnemyPositions(actualBoard, myKingColor)

        for(enemyPosition in enemyPositions) {
            if (pieceAttacksKing(gameState, enemyPosition, kingPosition)) {
                return true // me deja en check
            }
        }
        return false
    }

    //OK
    private fun getKingPosition(actualBoard: IBoard, kingColor: Color): Position? {
        actualBoard.getOccupiedPositions().forEach {
            coordinate ->
            if (actualBoard.getPieceByPosition(coordinate)?.type == PieceType.ChessPieceType.KING && actualBoard.getPieceByPosition(coordinate)?.color == kingColor) {
                return coordinate
            }
        }
        return null
    }

    private fun getEnemyPositions(actualBoard: IBoard, kingColor: Color): List<Position> {
        val enemyPositions: MutableList<Position> = mutableListOf()
        actualBoard.getOccupiedPositions().forEach {
            coordinate ->
            if (actualBoard.getPieceByPosition(coordinate)?.color != kingColor) {
                enemyPositions.add(coordinate)
            }
        }
        return enemyPositions
    }

    private fun pieceAttacksKing(gameState: IGameState,
                                 enemyPosition: Position,
                                 kingPosition: Position): Boolean {
        val enemy : Piece = gameState.getCurrentBoard().getPieceByPosition(enemyPosition) ?: throw NoSuchElementException("No esta la pieza capo")
        // checkea si para este enemigo es valido moverse al rey según las reglas del gameState
        return when (enemy.validateMove( Movement(enemyPosition, kingPosition), gameState)) {
            is ValidatorResultValid -> true
            is ValidatorResponse.ValidatorResultInvalid -> false
        }
    }

}