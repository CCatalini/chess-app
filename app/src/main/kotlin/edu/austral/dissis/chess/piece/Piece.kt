package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.validator.ValidatorResponse

//pieza genérica
data class Piece(val id: String,
                 val color: Color,
                 val type : PieceType,
                 val validator : edu.austral.dissis.common.validator.Validator,
                 private var moveCounter : Int = 0) {


    fun incrementMoveCounter() {
        moveCounter++
    }

    fun getMoveCounter(): Int {
        return moveCounter
    }

    fun validateMove(movement: Movement, gameState: IGameState): ValidatorResponse {
        return validator.validate(movement, gameState)
    }

}