package edu.austral.dissis.server.listener

import edu.austral.dissis.adapter.Adapter
import edu.austral.dissis.server.gameServer.GameServer
import edu.austral.dissis.server.payload.InitializePayload
import edu.austral.ingsis.clientserver.ServerConnectionListener

class InitializeListener(private val gameServer: GameServer) : ServerConnectionListener {

    //se llama cuando alguien se conecta al servidor
    override fun handleClientConnection(clientId: String) {
        val currentGameState = gameServer.getGameState()
        val adapterGameState = Adapter(currentGameState).init()
        val payload = InitializePayload(adapterGameState.boardSize, adapterGameState.pieces, adapterGameState.currentPlayer)
        gameServer.sendInitialize(clientId, payload)
    }

    override fun handleClientConnectionClosed(clientId: String) {
        println("Client $clientId disconnected")
    }

}
