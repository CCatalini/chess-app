package edu.austral.dissis

const val ROWS = 8
const val COLUMNS = 8
val GAME_TYPE = GameType.CHESS


enum class GameType {
    CHECKERS,
    CHESS,
    CAPABLANCA
}