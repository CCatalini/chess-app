package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.validator.Validator

//pieza genérica
data class Piece( val id: String,
                  val color: Color,
                  val type : PieceType,
                  val validator : Validator,
                  private val moveCounter : Int = 0) {

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