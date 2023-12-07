package edu.austral.dissis.common.piece

import edu.austral.dissis.common.Color


interface PieceInitializer {

    fun initialize(color: Color): Piece
    fun initialize(color: Color, id: String) : Piece
}