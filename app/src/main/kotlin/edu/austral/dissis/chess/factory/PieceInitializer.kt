package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece


interface PieceInitializer {

    fun initialize(color: Color): Piece
    fun initialize(color: Color, id: String) : Piece
}