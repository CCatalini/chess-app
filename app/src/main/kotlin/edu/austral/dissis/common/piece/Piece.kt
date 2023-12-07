package edu.austral.dissis.common.piece

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.ValidatorResponse

//pieza genérica
data class Piece(val id: String,
                 val color: Color,
                 val type : PieceType,
                 val validator : Validator,
                 private var moveCounter : Int = 0) {


    fun incrementMoveCounter() : Piece {
        return this.copy(moveCounter = moveCounter + 1)
    }

    fun getMoveCounter(): Int {
        return moveCounter
    }

    fun validateMove(movement: Movement, gameState: IGameState): ValidatorResponse {
        return validator.validate(movement, gameState)
    }

}