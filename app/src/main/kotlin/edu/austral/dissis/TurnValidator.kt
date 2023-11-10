package edu.austral.dissis

import edu.austral.dissis.chess.GameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.piece.Color

/*
 * para que la implementen el chess / checkers
 */
interface TurnValidator {

    fun getTurn() : Color

    fun nextTurn(gameState: GameState) : TurnValidator

    // para validar que es mi turno
    // para el damas sirve cuando si o si hay que mover doble para comer porque esta guardando el movimiento
    // para borrar la pieza del medio -> postcondiciones
    fun validateTurn(gameState: GameState, movement: Movement) : Boolean
}