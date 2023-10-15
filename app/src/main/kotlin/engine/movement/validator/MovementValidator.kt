package engine.movement.validator

import GameState
import engine.movement.Movement

//para definir los tipos de movimientos que hay que validar
interface MovementValidator {

    fun validate(movement: Movement, gameState: GameState): Boolean
}