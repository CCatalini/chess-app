package engine.piece

import engine.validator.Validator

class Rook (private val id: String,
            private val color: Color,
            private val rules: List<Validator>) : Piece {


    override fun getId(): String {
        return id
    }

    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return PieceType.ROOK
    }

    override fun getRules(): List<Validator> {
        return rules
    }


}