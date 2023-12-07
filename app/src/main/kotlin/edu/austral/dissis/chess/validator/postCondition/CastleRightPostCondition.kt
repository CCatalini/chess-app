package edu.austral.dissis.chess.validator.postCondition

import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.chess.validator.move.ShortCastleValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.postCondition.PostConditionResult
import edu.austral.dissis.common.validator.postCondition.PostConditionValidator

class CastleRightPostCondition: PostConditionValidator {

    private val shortCastleValidator: Validator = ShortCastleValidator()

    override fun validate(gameState: IGameState, updatedBoard: IBoard): PostConditionResult {
        val movement = findMovement(gameState, updatedBoard)
        if (shortCastleValidator.validate(movement, gameState) is ValidatorResponse.ValidatorResultInvalid) return PostConditionResult.ResultInvalid("No se puede realizar el enroque")
        val newBoard = updateRookPosition(updatedBoard, movement)
        return PostConditionResult.ResultValid(newBoard)
    }

    private fun updateRookPosition(board: IBoard, movement: Movement): IBoard {
        val rook = board.getPieceByPosition(Position(movement.from.row,movement.from.column + 3))!!
        return board.updatePieceByPosition(Position(movement.from.row,movement.from.column + 1), rook).removePieceByPosition(Position(movement.from.row,movement.from.column + 3))
    }

    private fun findMovement(gameState: IGameState, updatedBoard: IBoard): Movement {
        val initialBoard = gameState.getCurrentBoard()
        val initialKingPosition = findKingPosition(initialBoard, gameState.getCurrentTurn())
        val updatedKingPosition = findKingPosition(updatedBoard, gameState.getCurrentTurn())
        return Movement(initialKingPosition, updatedKingPosition)
    }

    private fun findKingPosition(board: IBoard, color: Color): Position {
        val king = board.getPieces().find { it.color == color && it.type == PieceType.KING }!!
        return board.getPositionByPiece(king)!!
    }

}