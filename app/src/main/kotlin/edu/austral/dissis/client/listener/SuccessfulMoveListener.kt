package edu.austral.dissis.client.listener

import edu.austral.dissis.chess.gui.GameView
import edu.austral.dissis.chess.gui.NewGameState
import edu.austral.dissis.server.payload.GameStatePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class SuccessfulMoveListener(private val root : GameView) : MessageListener<GameStatePayload.SuccessfulMovePayload> {

    override fun handleMessage(message: Message<GameStatePayload.SuccessfulMovePayload>) {
        root.handleMoveResult(NewGameState(message.payload.newPieces, message.payload.nextTurn))
    }

}
