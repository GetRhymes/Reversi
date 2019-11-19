package Event

import Logic.Opponent
import tornadofx.FXEvent

class OpponentEvent(var opponent: Char,var  board: Array<CharArray>, var player: Char): FXEvent() {
}