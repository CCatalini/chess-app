package edu.austral.dissis.app


import edu.austral.dissis.checkers.factory.createCheckersNormalGame
import edu.austral.dissis.chess.factory.createChessNormalGame
import edu.austral.dissis.server.gameServer.GameServer



fun main() {

    GameServer(createChessNormalGame())

  //  GameServer(createChessCapablancaGame())

  //  GameServer(createCheckersNormalGame())
}