package edu.austral.dissis.server.probandoAndo

import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

// guarda el contenido del mensaje para un tipo especifico de mensaje
// para el ejemplo solo va a guardar string, para el contenido del mensaje
// no puede guardar interfaces, si clases
class MessageCollectorListener<P : Any> : MessageListener<P> {

    val messages = mutableListOf<P>()

    override fun handleMessage(message: Message<P>) {
        messages.add(message.payload)
        println(messages)
    }

    fun clear() {
        messages.removeAll { true }
    }
}