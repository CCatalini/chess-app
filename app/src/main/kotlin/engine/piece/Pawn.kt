package engine.piece

import engine.movement.validator.Validator

class Pawn (private val id: String,
            private val color: Color,
            private val rules: List<Validator>) : Piece {


    override fun getId(): String {
        return id
    }

    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return PieceType.PAWN
    }

    override fun getRules(): List<Validator> {
        return rules
    }
}