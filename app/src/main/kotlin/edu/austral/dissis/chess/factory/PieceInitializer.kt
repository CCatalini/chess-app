package edu.austral.dissis.chess.factory

import edu.austral.dissis.common.Color
import edu.austral.dissis.common.piece.Piece


interface PieceInitializer {

    fun initialize(color: Color): Piece
    fun initialize(color: Color, id: String) : Piece
}