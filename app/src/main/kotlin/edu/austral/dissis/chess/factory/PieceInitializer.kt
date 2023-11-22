package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece

//debería tener el sentido para el que se mueve las piezas
// para x → 1 der, -1 izq
// para y → 1 arriba, -1 abajo
interface PieceInitializer {

    fun initialize(color: Color): Piece
    fun initialize(color: Color, id: String) : Piece
}