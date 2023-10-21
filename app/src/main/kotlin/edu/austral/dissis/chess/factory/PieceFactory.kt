package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.piece.PieceType

// el pieceType es un enum con los nombres de las piezas
// el pieceFactory se va a encargar de crear las piezas nombre - inicializador
// PieceInitializer --> interfaz, las implementaciones van a tener las reglas de cada pieza con los And - Or validators
class PieceFactory (  private val pieces: Map<PieceType, PieceInitializer>){


}


