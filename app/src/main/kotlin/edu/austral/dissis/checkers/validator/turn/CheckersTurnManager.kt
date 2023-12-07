package edu.austral.dissis.checkers.validator.turn

import edu.austral.dissis.chess.movement.Movement
import edu.austral.dissis.common.Color
import edu.austral.dissis.common.TurnValidator
import edu.austral.dissis.common.board.IBoard
import edu.austral.dissis.common.board.Position
import edu.austral.dissis.common.game.IGameState
import edu.austral.dissis.common.piece.Piece
import edu.austral.dissis.common.validator.ValidatorResponse

class CheckersTurnManager(private val color: Color, private val posibleMoves: List<Movement>) : TurnValidator {
    override fun getTurn(): Color {
        return color
    }

    override fun nextTurn(gameState: IGameState): TurnValidator {
       return if (canCapture(gameState)) {
           nextTurnWithCapture(gameState)
       } else {
           nextTurnWithoutCapture()
       }
    }

    private fun nextTurnWithCapture(gameState: IGameState): TurnValidator {
        val newPosibleMoves = getPosibleEatenMoves(color, gameState)

        return if (newPosibleMoves.isNotEmpty()) {
            CheckersTurnManager(color, newPosibleMoves)
        } else {
            nextTurnWithoutCapture()
        }
    }

    private fun nextTurnWithoutCapture(): TurnValidator {
        return if (color == Color.WHITE) {
            CheckersTurnManager(Color.BLACK, listOf())
        } else {
            CheckersTurnManager(Color.WHITE, listOf())
        }
    }

    private fun canCapture(gameState: IGameState): Boolean {
        val board = gameState.getCurrentBoard()

        if (gameState.getBoards().size < 2) { //porque mínimo tuvo que haber movido 2 veces
            return false
        }
        val previousBoard = gameState.getBoards()[gameState.getBoards().size - 2]
        val movement = getLatestMovement(previousBoard, board)
        val pieceColor = board.getPieceByPosition(movement.to)?.color
        val posibleEatenMoves = getPosibleEatenMoves(pieceColor!!, gameState)

        return posibleEatenMoves.isNotEmpty()

    }

    override fun validateTurn(movement: Movement, gameState: IGameState): ValidatorResponse {
        val pieceToMove: Piece? = getPiece(movement, gameState)

        if (posibleMoves.isNotEmpty() && !posibleMoves.contains(movement)) {
            return ValidatorResponse.ValidatorResultInvalid("tenes que mover una pieza que pueda comer" )
        }
        if (pieceToMove != null) {
            if (pieceToMove.color == this.color) {
                return ValidatorResponse.ValidatorResultValid("Es tu turno")
            }
        }
        return ValidatorResponse.ValidatorResultInvalid("No es tu turno capo")
    }

    private fun getPiece (movement: Movement, gameState: IGameState): Piece? {
        return gameState.getCurrentBoard().getPieceByPosition(movement.from)
    }

    private fun getLatestMovement(previousBoard: IBoard, updatedBoard: IBoard): Movement {
        val previousBoardPieces = previousBoard.getOccupiedPositions()
        val updatedBoardPieces = updatedBoard.getOccupiedPositions() //piezas post movimiento

        val positionTo = updatedBoardPieces.first { !previousBoardPieces.contains(it) }
        val piece = updatedBoard.getPieceByPosition(positionTo)

        val positionFrom = previousBoard.getPositionByPiece(piece!!)
        return Movement(positionFrom!!, positionTo)
    }

    private fun getPosibleEatenMoves(pieceColor: Color, gameState: IGameState): List<Movement> {
        val board = gameState.getCurrentBoard()

        val positionsPiecesByColor = board.getOccupiedPositions().filter { board.getPieceByPosition(it)?.color == pieceColor }
        val posibleEatenMoves = mutableListOf<Movement>()
        for (position in positionsPiecesByColor) {
            val posibleMoves = getPosibleMovesByPosition (position)
            for (move in posibleMoves) {
                if (isEatingMovement(move, gameState )) {
                    posibleEatenMoves.add(move)
                }
            }
        }
        return posibleEatenMoves
    }

    private fun isEatingMovement(move: Movement, gameState: IGameState): Boolean {
        val board = gameState.getCurrentBoard()
        val piece = board.getPieceByPosition(move.from)!!

        return piece.validateMove(move, gameState) is ValidatorResponse.ValidatorResultValid
    }

    private fun getPosibleMovesByPosition (position: Position ): List<Movement> {
        val posibleMoves = mutableListOf<Movement>()
        val row = position.row
        val column = position.column
        val posiblePositions = listOf(Position(row + 2, column + 2), Position(row + 2, column - 2), Position(row - 2, column + 2), Position(row - 2, column - 2))
        for (posiblePosition in posiblePositions) {
            posibleMoves.add(Movement(position, posiblePosition))
        }
        return posibleMoves
    }


}
