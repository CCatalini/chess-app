package edu.austral.dissis.adapter

import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.FinishGameState
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.game.InvalidMoveGameState
import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.common.movement.Movement
import edu.austral.dissis.common.Color

class Adapter(private var gameState: IGameState) : GameEngine {

    override fun applyMove(move: Move) : MoveResult{
        val parsedMove = parseMove(move)
        return when (val result = gameState.movePiece(parsedMove)){
            is GameState -> { updateState(result) }
            is InvalidMoveGameState -> { InvalidMove(result.errorMessage) }
            is FinishGameState -> { GameOver(parseColor(result.getTurnManager().getTurn())) }
        }

    }

    override fun init(): InitialState {
        return InitialState(getBoardSize(gameState) , getPieces(gameState), getTurn(gameState))
    }




    private fun updateState(gameState: IGameState) : MoveResult{
        this.gameState = gameState
        return NewGameState(getPieces(gameState), getTurn(gameState))
    }

    //para castear mis piezas a las de la ui
    private fun getPieces(gameState: IGameState) : List<ChessPiece>{
        val positions = gameState.getCurrentBoard().getOccupiedPositions()
        val chessPieces = mutableListOf<ChessPiece>()
        for (position in positions){
            val piece = gameState.getCurrentBoard().getPieceByPosition(position)!!
            chessPieces.add(ChessPiece(piece.id, parseColor(piece.color), parsePosition(position), piece.type.toString().lowercase()))

        }
        return chessPieces
    }

    private fun getTurn(gameState: IGameState) : PlayerColor{
        return parseColor(gameState.getCurrentTurn())
    }

    private fun getBoardSize(gameState: IGameState) : BoardSize{
        val board : IBoard = gameState.getCurrentBoard()
        return BoardSize(board.getWidth(), board.getHeight())
    }

     private fun parseMove(move:Move ) : Movement {
        val from = Position(move.from.row - 1 , move.from.column - 1)
        val to  = Position(move.to.row - 1 , move.to.column -1 )
        return Movement(from, to)
    }

    private fun parseColor(color: Color): PlayerColor {
        return when(color){
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }
    }

    private fun parsePosition(position: Position): edu.austral.dissis.chess.gui.Position {
        return edu.austral.dissis.chess.gui.Position(position.row + 1, position.column+1)
    }



}