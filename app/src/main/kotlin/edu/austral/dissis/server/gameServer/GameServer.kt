package edu.austral.dissis.server.gameServer

import com.fasterxml.jackson.core.type.TypeReference
import edu.austral.dissis.common.game.FinishGameState
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.server.listener.InitializeListener
import edu.austral.dissis.server.listener.MovementListener
import edu.austral.dissis.server.payload.GameStatePayload
import edu.austral.dissis.server.payload.InitializePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.Server
import edu.austral.ingsis.clientserver.ServerBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder

//tiene el juego y lo que construye al server
class GameServer(private var gameState: IGameState,
                 private val builder: ServerBuilder = NettyServerBuilder.createDefault()  /* builder que nos dan */) {

    private val server : Server

    init {
        server = initializeServer() // devuelve la configuración del server
        server.start()
    }

    fun getGameState() : IGameState {
        return gameState
    }

    //le dice al cliente que tiene que inicializar su juego con la info del payload(tamaño del tablero, piezas, color)
    fun sendInitialize(clientID: String, payload: InitializePayload){
        server.sendMessage(clientID, Message("initialize", payload))
    }

    fun broadcastState(payload: GameStatePayload){
        when ( payload ) {
            // .broadcast() envía un mensaje a todos los clientes conectados
            is GameStatePayload.SuccessfulMovePayload -> server.broadcast(Message("successfulMove", payload))
            is GameStatePayload.InvalidMovePayload -> server.broadcast(Message("invalidMove", payload))
            is GameStatePayload.FinishGamePayload -> server.broadcast(Message("finishedGame", payload))
        }

    }

    // aplica el movimiento y devuelve un estado del juego (que puede cambiar o no)
    fun applyMove(movement: Movement) : IGameState {
       return when (val result = gameState.movePiece(movement)) {
           is FinishGameState, is InvalidMoveGameState -> result
           is GameState -> {
               this.gameState = result
               result
           }

       }
    }


    private fun initializeServer(): Server {
        return builder
            .withPort(420) // asignamos el puerto
            .withConnectionListener(InitializeListener(this)) // asignamos lo que queremos hacer cuando alguien se conecta (el listener que va a usar)
            // se suscribe al MovementLIstener porque solo le interesa recibir los movimientos del cliente y a eso darle una respuesta
            .addMessageListener("move", object: TypeReference<Message<Movement>>(){}, MovementListener(this)) // asignamos lo que queremos hacer cuando recibimos un movimiento de un cliente
            .build() // devuelve el server
    }



}