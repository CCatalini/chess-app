package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.validator.Validator

interface Piece {

    fun getId(): String
    fun getColor(): Color
    fun getType(): PieceType

    fun getValidator(): Validator
}