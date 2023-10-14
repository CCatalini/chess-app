package movement.validator

import GameState
import board.Board
import board.BoardImpl
import board.Position
import movement.Movement
import piece.Piece

// para ver que el camino esta vacio
class EmptyPathValidator : MovementValidator {

    override fun validate(movement: Movement, gameState: GameState): Boolean {

        TODO("Not yet implemented")
    }


    private fun  getPositionByPiece(position: Position, gameState: GameState) {

    }
}