package edu.austral.dissis.server.gameServer

import com.fasterxml.jackson.core.type.TypeReference
import edu.austral.dissis.common.game.FinishGameState
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.server.listener.MovementListener
import edu.austral.dissis.server.listener.InitializeListener
import edu.austral.dissis.server.payload.GameStatePayload
import edu.austral.dissis.server.payload.InitializePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.Server
import edu.austral.ingsis.clientserver.ServerBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder

//tiene el juego y lo que construye al server
class GameServer(private var gameState: IGameState,
                 private val builder: ServerBuilder = NettyServerBuilder.createDefault() ) {

    private val server : Server

    init {
        server = initializeServer()
        server.start()
    }

    fun getGameState() : IGameState {
        return gameState
    }

    //le dice al cliente que teine que inicializar su juego con esta info (estas piezas)
    fun sendInitialize(clientID: String, payload: InitializePayload){
        server.sendMessage(clientID, Message("initialize", payload))
    }

    fun broadcastState(payload: GameStatePayload){
        when ( payload ) {
            is GameStatePayload.SuccessfulMovePayload -> server.broadcast(Message("successfulMove", payload))
            is GameStatePayload.InvalidMovePayload -> server.broadcast(Message("invalidMove", payload))
            is GameStatePayload.FinishGamePayload -> server.broadcast(Message("finishedGame", payload))
        }

    }

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
            .addMessageListener("move", object: TypeReference<Message<Movement>>(){}, MovementListener(this)) // asignamos lo que queremos hacer cuando recibimos un movimiento de un cliente
            .build() // devuelve el server
    }



}