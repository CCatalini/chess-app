package engine.piece

import engine.validator.Validator

class Bishop(private val id: String,
             private val color: Color,
             private val rules: List<Validator>) : Piece {


    override fun getId(): String {
        return id
    }

    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return PieceType.BISHOP
    }

    override fun getRules(): List<Validator> {
        return rules
    }
}