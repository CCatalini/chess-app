package edu.austral.dissis.app

import edu.austral.dissis.chess.factory.GameFactory.Companion.createChessCapablancaGame
import edu.austral.dissis.chess.factory.GameFactory.Companion.createChessNormalGame
import edu.austral.dissis.server.gameServer.GameServer



fun main() {

    GameServer(createChessNormalGame())

  //  GameServer(createChessCapablancaGame())
}