package piece

interface Piece {

    fun getId(): String
    fun getColor(): Color
    fun getType(): PieceType
}