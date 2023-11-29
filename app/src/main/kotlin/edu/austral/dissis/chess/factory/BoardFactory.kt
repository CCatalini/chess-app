package edu.austral.dissis.chess.factory

import edu.austral.dissis.chess.factory.pieceInit.*
import edu.austral.dissis.chess.piece.Color
import edu.austral.dissis.chess.piece.Piece
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position

class BoardFactory {
    companion object{

        fun createClassicChessBoard(): IBoard {



            var map: Map<Position, Piece> = mutableMapOf(
                Position(0, 0) to RookInitializer().initialize(Color.WHITE),
                Position(0,7) to RookInitializer().initialize(Color.WHITE),
                Position(7,0) to RookInitializer().initialize(Color.BLACK),
                Position(7,7) to RookInitializer().initialize(Color.BLACK),

                Position(0,1) to KnightInitializer().initialize(Color.WHITE),
                Position(0,6) to KnightInitializer().initialize(Color.WHITE),
                Position(7,1) to KnightInitializer().initialize(Color.BLACK),
                Position(7,6) to KnightInitializer().initialize(Color.BLACK),

                Position(0,2) to BishopInitializer().initialize(Color.WHITE),
                Position(0,5) to BishopInitializer().initialize(Color.WHITE),
                Position(7,2) to BishopInitializer().initialize(Color.BLACK),
                Position(7,5) to BishopInitializer().initialize(Color.BLACK),

                Position(0,3) to QueenInitializer().initialize(Color.WHITE),
                Position(7,3) to QueenInitializer().initialize(Color.BLACK),

                Position(0,4) to KingInitializer().initialize(Color.WHITE),
                Position(7,4) to KingInitializer().initialize(Color.BLACK),

            )

            for (i in 0..7) {
                map = map.plus(Position(1, i) to PawnInitializer().initialize(Color.WHITE))
                map = map.plus(Position(6, i) to PawnInitializer().initialize(Color.BLACK))
            }

            return Board(8, 8, map)
        }

        fun createCapablancaChessBoard(): IBoard {
            var map: Map<Position, Piece> = mutableMapOf(
                Position(0, 0) to RookInitializer().initialize(Color.WHITE),
                Position(0, 9) to RookInitializer().initialize(Color.WHITE),
                Position(9, 0) to RookInitializer().initialize(Color.BLACK),
                Position(9, 9) to RookInitializer().initialize(Color.BLACK),

                Position(0, 1) to KnightInitializer().initialize(Color.WHITE),
                Position(0, 8) to KnightInitializer().initialize(Color.WHITE),
                Position(9, 1) to KnightInitializer().initialize(Color.BLACK),
                Position(9, 8) to KnightInitializer().initialize(Color.BLACK),

                Position(0, 2) to ArchbishopInitializer().initialize(Color.WHITE),
                Position(9, 2) to ArchbishopInitializer().initialize(Color.BLACK),

                Position(0, 3) to BishopInitializer().initialize(Color.WHITE),
                Position(0, 6) to BishopInitializer().initialize(Color.WHITE),
                Position(9, 3) to BishopInitializer().initialize(Color.BLACK),
                Position(9, 6) to BishopInitializer().initialize(Color.BLACK),

                Position(0, 7) to ChancellorInitializer().initialize(Color.WHITE),
                Position(9, 7) to ChancellorInitializer().initialize(Color.BLACK),

                Position(0, 4) to QueenInitializer().initialize(Color.WHITE),
                Position(9, 4) to QueenInitializer().initialize(Color.BLACK),


                Position(0, 5) to KingInitializer().initialize(Color.WHITE),
                Position(9, 5) to KingInitializer().initialize(Color.BLACK),
            )

            for (i in 0..9) {
                map = map.plus(Position(1, i) to PawnInitializer().initialize(Color.WHITE))
                map = map.plus(Position(8, i) to PawnInitializer().initialize(Color.BLACK))
            }

            return Board(10, 8, map)
        }

    }
}
