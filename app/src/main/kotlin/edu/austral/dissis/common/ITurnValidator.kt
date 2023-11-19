package edu.austral.dissis.common

import edu.austral.dissis.chess.game.IGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.common.validator.ValidatorResponse

/*
 * para que la implementen el chess / checkers
 */
interface ITurnValidator {

    fun getTurn() : Color

    fun nextTurn() : ITurnValidator

    // para validar que es mi turno
    // para el damas sirve cuando si o si hay que mover doble para comer porque esta guardando el movimiento
    // para borrar la pieza del medio -> postcondiciones
    fun validateTurn(movement: Movement, gameState: IGameState) : ValidatorResponse
}