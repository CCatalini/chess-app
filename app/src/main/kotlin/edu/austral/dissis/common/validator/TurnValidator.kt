package edu.austral.dissis.common.validator

import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.game.IGameState

/*
 * para que la implementen el chess / checkers
 */
interface TurnValidator {

    fun getTurn() : Color

    fun nextTurn(gameState: IGameState) : TurnValidator

    // para validar que es mi turno
    // para el damas sirve cuando si o si hay que mover doble para comer porque esta guardando el movimiento
    // para borrar la pieza del medio -> postcondiciones
    fun validateTurn(movement: Movement, gameState: IGameState) : ValidatorResponse
}