package engine.piece

import engine.validator.Validator

//pieza generica
class PieceImpl( private val id: String, private val color: Color, private val type : PieceType, private val validator : Validator) : Piece {
    //paso un validador porque puede ser un and o un or validator que tiene una lista de validadores

    override fun getId(): String {
        return id
    }

    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return type
    }

    //para cambiar
    override fun getValidator(): Validator {
        return validator
    }
}