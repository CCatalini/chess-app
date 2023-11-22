package edu.austral.dissis.client.listener

import edu.austral.dissis.chess.gui.GameView
import edu.austral.dissis.chess.gui.InvalidMove
import edu.austral.dissis.server.payload.GameStatePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class InvalidMoveListener(private val root: GameView) : MessageListener<GameStatePayload.InvalidMovePayload> {

    override fun handleMessage(message: Message<GameStatePayload.InvalidMovePayload>) {
        root.handleMoveResult(InvalidMove(message.payload.message))
    }

}
