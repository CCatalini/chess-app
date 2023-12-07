package edu.austral.dissis.client

import com.fasterxml.jackson.core.type.TypeReference
import edu.austral.dissis.chess.gui.GameView
import edu.austral.dissis.client.listener.*
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.server.payload.GameStatePayload
import edu.austral.dissis.server.payload.InitializePayload
import edu.austral.ingsis.clientserver.Client
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder
import java.net.InetSocketAddress

class GameClient {

    private lateinit var client: Client

    //manda al servidor el mensaje de tipo initialize para que le pase el estado actual del juego
    // y el cliente lo pueda mostrar en la UI.
    fun start(root: GameView){
        client = buildClient(root)
        client.connect()
        client.send(Message("initialize", Unit))
        root.addListener(ViewListener(this))
    }

    private fun buildClient(root: GameView): Client {
        return NettyClientBuilder
            .createDefault()
            .withAddress(InetSocketAddress("localhost", 420))
            .addMessageListener("initialize", object: TypeReference<Message<InitializePayload>>(){}, ClientInitializeListener(root))
            .addMessageListener("successfulMove", object: TypeReference<Message<GameStatePayload.SuccessfulMovePayload>>(){}, SuccessfulMoveListener(root))
            .addMessageListener("invalidMove", object: TypeReference<Message<GameStatePayload.InvalidMovePayload>>(){}, InvalidMoveListener(root))
            .addMessageListener("finishedGame", object: TypeReference<Message<GameStatePayload.FinishGamePayload>>(){}, FinishGameListener(root))
            .build()
    }

    fun applyMove(move: Movement){
        client.send(Message("move", move))
    }
}