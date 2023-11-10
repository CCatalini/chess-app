package edu.austral.dissis.server.probandoAndo

import edu.austral.ingsis.clientserver.ClientConnectionListener

// guarda si estas conectado o no
// El cliente solo puede estar conectado a un servidor
class ClientConnectionCollectorListener : ClientConnectionListener {

    var isConnected = false

    override fun handleConnection() {
        isConnected = true
    }

    override fun handleConnectionClosed() {
        isConnected = false
    }

    fun clear() {
        isConnected = false
    }
}