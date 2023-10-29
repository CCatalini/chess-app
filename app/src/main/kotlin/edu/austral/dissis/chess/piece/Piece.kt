package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.validator.Validator

//pieza genérica
data class Piece(private val id: String,
            private val color: Color,
            private val type : PieceType,
            private val moveCounter : Int = 0,
            private val validator : Validator) {

    fun getId(): String {
        return id
    }

    fun getColor(): Color {
        return color
    }

    fun getType(): PieceType {
        return type
    }

    //para cambiar
    fun getValidator(): Validator {
        return validator
    }

    fun getMoveCounter(): Int {
        return moveCounter
    }
}