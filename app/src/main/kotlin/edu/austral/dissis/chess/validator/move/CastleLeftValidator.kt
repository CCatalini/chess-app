package edu.austral.dissis.chess.validator.move

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.composition.AndValidator

class CastleLeftValidator: Validator {
    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {

        val board = gameState.getCurrentBoard()
        if (board.getPieceByPosition(movement.from)!!.type != PieceType.KING) return ValidatorResponse.ValidatorResultInvalid("La pieza que estas moviendo no es un rey")

        if (movement.to.row != movement.from.row) return ValidatorResponse.ValidatorResultInvalid("El rey solo se puede mover en horizontal (Para el enroque)")

        if (movement.to.column != movement.from.column - 2 ) return ValidatorResponse.ValidatorResultInvalid("El rey solo se puede mover dos casillas a la derecha (Para el enroque)")

        if (!noPiecesBetweenCastling(board, movement)) return ValidatorResponse.ValidatorResultInvalid("No hay piezas entre el rey y la torre")

        val rook = board.getPieceByPosition(Position(movement.from.row,movement.from.column - 4)) ?: return ValidatorResponse.ValidatorResultInvalid("No hay torre en la posicion indicada")

        return ValidatorResponse.ValidatorResultValid("proceda!")
    }

    private fun noPiecesBetweenCastling(board: IBoard, movement: Movement): Boolean {
        for (i in movement.from.column + 1 until movement.to.column) {
            val auxPos: Position = Position(movement.from.row, i)
            if (board.getPieceByPosition(auxPos) != null) return false
        }
        return true
    }
}