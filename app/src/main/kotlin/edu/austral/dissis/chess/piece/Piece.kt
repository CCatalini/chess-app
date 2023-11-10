package edu.austral.dissis.chess.piece

import edu.austral.dissis.chess.validator.Validator

//pieza genérica
data class Piece( val id: String,
                  val color: Color,
                  val type : PieceType,
                  val validator : Validator,
                  private val moveCounter : Int = 0) {
    @JvmName("getIdCustomName")
    fun getId(): String {
        return id
    }

    @JvmName("getIdCustomName")
    fun getColor(): Color {
        return color
    }
    @JvmName("getIdCustomName")
    fun getType(): PieceType {
        return type
    }

    //para cambiar
    @JvmName("getIdCustomName")
    fun getValidator(): Validator {
        return validator
    }

    @JvmName("getIdCustomName")
    fun getMoveCounter(): Int {
        return moveCounter
    }
}