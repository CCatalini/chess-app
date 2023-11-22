package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.chess.piece.PieceType
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.ValidatorResponse.ValidatorResultValid

//queda sin implementar Validator porque lo usamos auxiliar
class CheckValidator {

     fun validate( gameState: IGameState): Boolean {

        val kingColor: Color = gameState.getCurrentTurn()
        val actualBoard: IBoard = gameState.getCurrentBoard()
        val kingPosition: Position = getKingPosition(actualBoard, kingColor)?: throw NoSuchElementException("No esta el rey capo")
        val enemyCoordinates: List<Position> = actualBoard.getOccupiedPositions()

        for(position in enemyCoordinates) {
            if (pieceAttacksKing(gameState, position, kingColor, kingPosition)) {
                return true
            }
        }
        return false
    }

    private fun getKingPosition(actualBoard: IBoard, color: Color): Position? {
        actualBoard.getOccupiedPositions().forEach { coordinate ->
            if (actualBoard.getPieceByPosition(coordinate)?.type == PieceType.KING && actualBoard.getPieceByPosition(coordinate)?.color == color) {
                return coordinate
            }
        }
        return null
    }

    private fun pieceAttacksKing(gameState: IGameState,
                                 position: Position,
                                 kingColor: Color,
                                 kingPosition: Position): Boolean {
        if (gameState.getCurrentBoard().getPieceByPosition(position)?.color != kingColor) {
            val piece : Piece = gameState.getCurrentBoard().getPieceByPosition(position) ?: throw NoSuchElementException("No esta la pieza capo")
            when (
                piece.validateMove(Movement(position, kingPosition), gameState  )
            ) {
                is ValidatorResultValid -> return true
                is ValidatorResponse.ValidatorResultInvalid -> {}
            }
        }
        return false
    }

}