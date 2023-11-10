package edu.austral.dissis.server.probandoAndo

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import edu.austral.dissis.server.probandoAndo.ServerMain.Companion.createClientBuilder
import edu.austral.ingsis.clientserver.*
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder
import java.net.InetSocketAddress


class ServerMain {

    data class Data(val field: String)

    val client2DataCollector = MessageCollectorListener<Data>()
    val client3DataCollector = MessageCollectorListener<Data>()

    companion object {
        private const val HOST = "localhost"
        private const val PORT = 10_000

        val ADDRESS = InetSocketAddress(HOST, PORT)

        const val DATA_MESSAGE_TYPE = "data-type"
        const val RAW_MESSAGE_TYPE = "raw-type"

         val serverConnectionListener = ServerConnectionCollectorListener()
         val clientConnectionListener = ClientConnectionCollectorListener()

        // Raw Collector → guardan los mensajes de un tipo
         val serverRawCollector = MessageCollectorListener<String>()
         val client1RawCollector = MessageCollectorListener<String>()

        fun createServerBuilder(): ServerBuilder =
            NettyServerBuilder.createDefault()
                .withPort(PORT)

        fun createClientBuilder(): ClientBuilder =
            NettyClientBuilder.createDefault()
                .withAddress(ADDRESS)

        fun createServer(): Server = NettyServerBuilder.createDefault()
            .withPort(PORT)
            .withConnectionListener(serverConnectionListener) //es default del server
            .addMessageListener(DATA_MESSAGE_TYPE, jacksonTypeRef(), serverRawCollector)
            .build()

        // aca le dice: " vos te vas a conectar aca pero no todavía no estas conectado"
        fun createClient(): Client = NettyClientBuilder.createDefault()
            .withAddress(ADDRESS)
            .withConnectionListener(clientConnectionListener)
            .build()

    }



}

fun main() {
    val server = ServerMain.createServer()
    server.start()

    val client = ServerMain.createClient()
    client.connect()

    // guarda los mensajes que recibe el servidor de los clientes
    val client2DataCollector = MessageCollectorListener<String>()
    val client3DataCollector = MessageCollectorListener<String>()

    val client2: Client = createClientBuilder()
        .addMessageListener(ServerMain.DATA_MESSAGE_TYPE, jacksonTypeRef(), client2DataCollector) //aca se esta suscribiendo al listener con el MessageCollectorLister<>()
        .build()

    val client3: Client = createClientBuilder()
        .addMessageListener(ServerMain.DATA_MESSAGE_TYPE, jacksonTypeRef(), client3DataCollector)
        .build()

    client2.connect()
    client3.connect()

    client.send(Message(ServerMain.DATA_MESSAGE_TYPE, "probando desde el client1"))

    client2.send(Message(ServerMain.DATA_MESSAGE_TYPE, "probando desde el client 2"))

    server.broadcast(Message(ServerMain.DATA_MESSAGE_TYPE, "probando desde el server"))


    client.closeConnection()
    client2.closeConnection()
    client3.closeConnection()

    server.stop()



}



/*
   * "mensaje" = "evento"
   *
   * voy a tener que plantear un listener por cada cosa que muestro en la UI
   *   → mov Válido, mov Inválido, termino el juego
   *
   * los messages son los eventos (eventType)
   *
   *  Un tipo de Listener para cada tipo de mensaje
   *
   * data class Message<P : Any>(val type: String, val payload: P)
   * payload-> seria como el dto de un objeto.
   *
   * send() -> es de un server y es para mandarle un mensaje a UN cliente particular
   * broadcast -> es para mandarle un mensaje a todos los clientes
*/