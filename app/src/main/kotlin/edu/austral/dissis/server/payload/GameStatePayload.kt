package edu.austral.dissis.server.payload

import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.PlayerColor

sealed interface GameStatePayload {
    data class FinishGamePayload(val winner: PlayerColor) : GameStatePayload
    data class SuccessfulMovePayload( val newPieces: List<ChessPiece>, val nextTurn: PlayerColor) : GameStatePayload
    data class InvalidMovePayload(val message: String) : GameStatePayload
}
