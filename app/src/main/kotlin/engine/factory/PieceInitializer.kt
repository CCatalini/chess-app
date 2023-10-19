package engine.factory

import engine.piece.Color
import engine.piece.Piece

//debería tener el sentido para el que se mueve las piezas
// para x → 1 der, -1 izq
// para y → 1 arriba, -1 abajo
interface PieceInitializer {

    fun initialize(color: Color): Piece
}