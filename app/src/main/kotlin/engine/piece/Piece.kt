package engine.piece

import engine.movement.validator.MovementValidator

interface Piece {

    fun getId(): String
    fun getColor(): Color
    fun getType(): PieceType
    fun getRules(): List<MovementValidator>
}