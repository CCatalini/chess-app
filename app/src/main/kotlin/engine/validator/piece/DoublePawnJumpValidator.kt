package engine.validator.piece

import GameState
import engine.movement.Movement
import engine.validator.Validator

//para el primer mov del peon
// ver si no puede ser una composicion de otros movimientos con un limite y un checkeo de que sea el primer movimiento de una pieza
class DoublePawnJumpValidator : Validator {
    override fun validate(movement: Movement, gameState: GameState): Boolean {
        TODO("Not yet implemented")
    }
}