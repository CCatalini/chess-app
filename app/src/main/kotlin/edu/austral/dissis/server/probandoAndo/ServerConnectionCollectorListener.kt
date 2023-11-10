package edu.austral.dissis.server.probandoAndo

import edu.austral.ingsis.clientserver.ServerConnectionListener

class ServerConnectionCollectorListener : ServerConnectionListener {

    //para los clientes que estan conectados al servidor
    val clients = mutableListOf<String>()

    override fun handleClientConnection(clientId: String) {
        clients.add(clientId)
        println("me conecte juju")
    }

    override fun handleClientConnectionClosed(clientId: String) {
        clients.remove(clientId)
    }

    fun clear() {
        clients.clear()
    }
}