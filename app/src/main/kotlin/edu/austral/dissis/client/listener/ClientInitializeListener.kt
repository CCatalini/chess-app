package edu.austral.dissis.client.listener

import edu.austral.dissis.chess.gui.GameView
import edu.austral.dissis.chess.gui.InitialState
import edu.austral.dissis.server.payload.InitializePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

// interpreta el mensaje del servidor
class ClientInitializeListener(private val root: GameView) : MessageListener<InitializePayload> {

    override fun handleMessage(message: Message<InitializePayload>) {
       //cuando me conecto el server manda como esta compuesto el actual state del game y lo cargo en la ui
        root.handleInitialState(InitialState(message.payload.boardSize, message.payload.pieces, message.payload.playerColor))
    }

}
