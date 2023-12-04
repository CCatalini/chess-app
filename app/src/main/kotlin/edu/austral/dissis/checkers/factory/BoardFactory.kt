package edu.austral.dissis.checkers.factory

import edu.austral.dissis.checkers.factory.pieceInit.ManInitializer
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.Board
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.piece.Piece

    fun createCheckersBoard() : IBoard {
        val map: MutableMap<Position, Piece> = mutableMapOf()

        for (i in 1..3) {
            val startColumn = if (i % 2 == 1) 2 else 1 // para que empiece desde la segunda columna para filas impares
            for (j in startColumn..8 step 2) {
                map[Position(i, j)] = ManInitializer().initialize(Color.WHITE)
            }
        }

        for (i in 6..8) {
            val startColumn = if (i % 2 == 1) 2 else 1 // Start from 2nd column for odd rows and 1st column for even rows
            for (j in startColumn..8 step 2) {
                map[Position(i, j)] = ManInitializer().initialize(Color.BLACK)
            }
        }

        return Board(8, 8, map)
    }

