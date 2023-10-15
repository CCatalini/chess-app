package engine.piece

class PieceImpl(private val id: String,
                private val color: Color,
                private val type: PieceType
) : Piece {

    override fun getId(): String {
        return id
    }
    override fun getColor(): Color {
        return color
    }

    override fun getType(): PieceType {
        return type
    }
}