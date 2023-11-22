package edu.austral.dissis.server.payload

import edu.austral.dissis.chess.gui.BoardSize
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.PlayerColor

data class InitializePayload (val boardSize: BoardSize,
                              val pieces: List<ChessPiece>,
                              val playerColor: PlayerColor){

}
