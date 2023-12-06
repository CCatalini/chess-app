package edu.austral.dissis.checkers.validator

import edu.austral.dissis.common.board.Position
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

class EnemyInBetween : Validator{

    override fun validate(movement: Movement, gameState: IGameState): ValidatorResponse {

        val middlePosition : Position = getMiddlePosition(movement)
        val middlePiece = gameState.getCurrentBoard().getPieceByPosition(middlePosition)

        return if ( isEnemy(middlePiece, gameState.getCurrentTurn()) ){
            ValidatorResponse.ValidatorResultValid("Es enemigo")
            //TODO POST CONDICIONES
            // - SI COME --> BORRAR LA PIEZA
            // - UNA VEZ QUE COME VER SI PUEDE COMER DE NUEVO Y HACERLO
        }else{
            ValidatorResponse.ValidatorResultInvalid("no es enemigo")
        }

    }

    private fun getMiddlePosition(move: Movement): Position{
        val midRow = (move.from.row + move.to.row) / 2
        val midColumn = (move.from.column + move.to.column) / 2
        return Position(midRow, midColumn)
    }

    private fun isEnemy(piece: Piece?, currentTurn: Color): Boolean{
        if(piece == null) return false
        return piece.color != currentTurn
    }
}