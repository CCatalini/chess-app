package engine.validator

import GameState
import engine.movement.Movement

//para definir los tipos de movimientos que hay que validar
interface Validator {

    fun validate(movement: Movement, gameState: GameState): Boolean

    // en ve de retornar un boolean, hacer una sealed interface MovementResult que las implementaciones sean
    // MovementResultValid y MovementResultInvalid --> en los constructores hay que pasarle un message con el motivo de falla
    //y hay que hacer pattern matching
    //
}