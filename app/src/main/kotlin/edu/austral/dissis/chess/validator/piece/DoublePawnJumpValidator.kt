package edu.austral.dissis.chess.validator.piece

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.Validator

//para el primer mov del peon
// ver si no puede ser una composicion de otros movimientos con un limite y un checkeo de que sea el primer movimiento de una pieza
class DoublePawnJumpValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}