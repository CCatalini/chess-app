package engine.piece

import engine.movement.validator.MovementValidator

class Bishop(private val id: String,
             private val color: Color,
             private val rules: List<MovementValidator>) : Piece {


    override fun getId(): String {
        return id
    }

    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return PieceType.BISHOP
    }

    override fun getRules(): List<MovementValidator> {
        return rules
    }
}