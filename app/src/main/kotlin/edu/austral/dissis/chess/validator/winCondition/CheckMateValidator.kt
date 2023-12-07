package edu.austral.dissis.chess.validator.winCondition

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.chess.validator.postCondition.CheckValidator
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.GameState
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.piece.PieceType
import edu.austral.dissis.common.validator.ValidatorResponse
import edu.austral.dissis.common.validator.winCondition.WinCondition

class CheckMateValidator : WinCondition {
    //nota tengo que crear un game state auxiliar cuando llamo a este con el tablero actualizado del movimiento
    override fun isWin(gameState: IGameState): Boolean {
        val kingColor = gameState.getTurnManager().nextTurn(gameState).getTurn() //el color del rey es el del próximo turno, que seria el enemigo
        val board = gameState.getCurrentBoard()
        val positionsOfAlliedKingPieces = getPositionsByColor(board, kingColor)
        val possibleMoves = getPossibleMoves(positionsOfAlliedKingPieces, gameState)
        for(pos in possibleMoves) {
            if (moveIsNotCheck(pos, gameState, kingColor)) {
                return false
            }
        }
        return true
    }

    private fun getKingPosition(board: IBoard, kingColor: Color): Position? {
        board.getOccupiedPositions().forEach {
                coordinate ->
            val piece = board.getPieceByPosition(coordinate)
            if (isKing(piece) && matchesColor(piece, kingColor)) {
                return coordinate
            }
        }
        return null
    }

    private fun isKing(piece: Piece?): Boolean{
        return (piece?.type == PieceType.KING)
    }

    private fun matchesColor(piece: Piece?, color: Color): Boolean{
        return (piece?.color == color)
    }

    private fun getPositionsByColor(board: IBoard, color: Color) : List<Position> {
        val occupiedPositions = mutableListOf<Position>()

        for(position in board.getOccupiedPositions()){
            val piece = board.getPieceByPosition(position)
            if (piece != null && piece.color == color) {
                occupiedPositions.add(position)
            }
        }
        return occupiedPositions
    }

    private fun getPossibleMoves(positions: List<Position>, gameState: IGameState) : List<Movement> {
        val possibleMoves = mutableListOf<Movement>()
        for(pos in positions) {
            possibleMoves.addAll(getPieceValidMoves(pos, gameState))
        }
        return possibleMoves
    }

    private fun getPieceValidMoves(occupiedPosition: Position, gameState: IGameState) : List<Movement> {
        val piece = gameState.getCurrentBoard().getPieceByPosition(occupiedPosition) ?: throw NoSuchElementException("No estÃ¡ la pieza, capo")
        val validMoves = mutableListOf<Movement>()
        for (row in 0 until gameState.getCurrentBoard().getWidth()) {
            for (column in 0 until gameState.getCurrentBoard().getHeight()) {
                val positionTo = Position(row, column)
                val movement = Movement(occupiedPosition, positionTo)
                val validator = piece.validateMove(movement, gameState)
                if (validator is ValidatorResponse.ValidatorResultValid) {
                    validMoves.add(movement)
                }
            }
        }
        return validMoves
    }

    private fun moveIsNotCheck(movement: Movement, gameState: IGameState, kingColor: Color): Boolean {
        val newGameState = simulateMove(movement, gameState) //simulo el movimiento
        return !CheckValidator().inCheck(newGameState, kingColor) //me fijo si me deja al actual turno en check
    }

    private fun simulateMove(movement: Movement, gameState: IGameState): IGameState {
        val newBoard = gameState.getCurrentBoard().update(movement)
        val newBoards = gameState.getBoards().toMutableList()
        newBoards.add(newBoard)
        return GameState(
            newBoards,
            gameState.getWinCondition(),
            gameState.getTurnManager(),
            gameState.getListPreConditions(),
            gameState.getListPostConditions()
        )
    }

}