package chess.board

import edu.austral.dissis.chess.factory.pieceInit.*
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Piece

fun createRookTestBoard(): IBoard {
    val map: Map<Position, Piece> = mutableMapOf(
        Position(3, 3) to RookInitializer().initialize(Color.WHITE),
        Position(3, 5) to RookInitializer().initialize(Color.BLACK),
    )
    return Board(8, 8, map)
}

fun createBishopTestBoard(): IBoard {
    val map: Map<Position, Piece> = mutableMapOf(
        Position(3, 3) to BishopInitializer().initialize(Color.WHITE),
        Position(4, 4) to BishopInitializer().initialize(Color.BLACK),
    )
    return Board(8, 8, map)
}

fun createKnightTestBoard(): IBoard {
    val map: Map<Position, Piece> = mutableMapOf(
        Position(3, 3) to KnightInitializer().initialize(Color.WHITE),
        Position(3, 4) to KnightInitializer().initialize(Color.WHITE),
        Position(4, 5) to KnightInitializer().initialize(Color.BLACK),
    )
    return Board(8, 8, map)
}

fun createKingTestBoard(): IBoard {
    val map: Map<Position, Piece> = mutableMapOf(
        Position(3, 3) to KingInitializer().initialize(Color.WHITE),
        Position(3, 4) to KingInitializer().initialize(Color.WHITE),
        Position(4, 4) to KingInitializer().initialize(Color.BLACK),
    )
    return Board(8, 8, map)
}

fun createQueenTestBoard(): IBoard {
    val map: Map<Position, Piece> = mutableMapOf(
        Position(3, 3) to QueenInitializer().initialize(Color.WHITE),
        Position(3, 5) to QueenInitializer().initialize(Color.WHITE),
        Position(4, 4) to QueenInitializer().initialize(Color.BLACK),
    )
    return Board(8, 8, map)
}
