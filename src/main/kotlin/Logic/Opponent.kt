
package Logic
var conditional = true

class Opponent {
    enum class Direction {
        DOWN_RIGHT, DOWN, RIGHT, UP, LEFT, UP_RIGHT, UP_LEFT, DOWN_LEFT
    }
    fun move(board: Array<CharArray>, opponent: Char, player: Char): MutableMap<Pair<Int, Int>, MutableList<Pair<Int, Direction>>> {
        val listOfPositionPlayer = mutableListOf<Pair<Int, Int>>()
        val listOfPositionOpponent = mutableListOf<Pair<Int, Int>>()
        val moveOption = mutableMapOf<Pair<Int, Int>, MutableList<Pair<Int, Direction>>>()

        for (line in 0 until board.size) {
            for (column in 0 until board[line].size) {
                if (board[line][column] == opponent) listOfPositionOpponent.add(Pair(line, column))
            }
        }

        for (realPosition in listOfPositionOpponent) {
            if(realPosition.first + 1 < 8 && realPosition.second + 1 < 8 && board[realPosition.first + 1][realPosition.second + 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first + 1, realPosition.second + 1))
            }
            if(realPosition.first + 1 < 8 && board[realPosition.first + 1][realPosition.second] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first + 1, realPosition.second))
            }
            if(realPosition.second + 1 < 8 && board[realPosition.first][realPosition.second + 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first, realPosition.second + 1))
            }
            if(realPosition.first - 1 > -1 && board[realPosition.first - 1][realPosition.second] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first - 1, realPosition.second))
            }
            if(realPosition.second - 1 > -1 && board[realPosition.first][realPosition.second - 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first, realPosition.second - 1))
            }
            if(realPosition.first - 1 > -1 && realPosition.second - 1 > -1 && board[realPosition.first - 1][realPosition.second - 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first - 1, realPosition.second - 1))
            }
            if(realPosition.first + 1 < 8 && realPosition.second - 1 > -1 && board[realPosition.first + 1][realPosition.second - 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first + 1, realPosition.second - 1))
            }
            if(realPosition.first - 1 > -1 && realPosition.second + 1 < 8 &&board[realPosition.first - 1][realPosition.second + 1] == '_') {
                listOfPositionPlayer.add(Pair(realPosition.first - 1, realPosition.second + 1))
            }
        }

        for (checker in listOfPositionPlayer) {
            moveOption[checker] = mutableListOf()
            if(checker.first < 7 && checker.second < 7 && board[checker.first + 1][checker.second + 1] == opponent) {
                var rowIndex = checker.first + 1
                var columnIndex = checker.second + 1
                while(rowIndex < 8 || columnIndex < 8) {
                    while(board[rowIndex][columnIndex] == opponent) {
                        if(rowIndex != 7 && columnIndex != 7) {
                            rowIndex += 1
                            columnIndex += 1
                        } else break
                    }
                    val numberOfCoups = rowIndex - checker.first
                    if (board[rowIndex][columnIndex] != '_' && board[rowIndex][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.DOWN_RIGHT))
                    }
                    break
                }
            }
            if(checker.first < 7 && board[checker.first + 1][checker.second] == opponent) {
                var rowIndex = checker.first+ 1
                while(rowIndex < 8) {
                    while(board[rowIndex][checker.second] == opponent) {
                        if(rowIndex != 7) {
                            rowIndex += 1
                        } else break
                    }
                    val numberOfCoups = rowIndex - checker.first
                    if (board[rowIndex][checker.second] != '_' && board[rowIndex][checker.second] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.DOWN))
                    }
                    break
                }
            }
            if(checker.second < 7 && board[checker.first][checker.second + 1] == opponent) {
                var columnIndex = checker.second + 1
                while(columnIndex < 8) {
                    while(board[checker.first][columnIndex] == opponent) {
                        if (columnIndex != 7) {
                            columnIndex += 1
                        } else break
                    }
                    val numberOfCoups = columnIndex - checker.second
                    if (board[checker.first][columnIndex] != '_' && board[checker.first][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.RIGHT))
                    }
                    break
                }
            }
            if(checker.first > 1 && board[checker.first - 1][checker.second] == opponent) {
                var rowIndex = checker.first - 1
                while(rowIndex > 0) {
                    while(board[rowIndex][checker.second] == opponent) {
                        if(rowIndex != 0) {
                            rowIndex -= 1
                        } else break
                    }
                    val numberOfCoups = checker.first - rowIndex
                    if (board[rowIndex][checker.second] != '_' && board[rowIndex][checker.second] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.UP))
                    }
                    break
                }
            }
            if(checker.second > 1 && board[checker.first][checker.second -  1] == opponent) {
                var columnIndex = checker.second - 1
                while(columnIndex > 0) {
                    while(board[checker.first][columnIndex] == opponent) {
                        if(columnIndex != 0) {
                            columnIndex -= 1
                        } else break
                    }
                    val numberOfCoups = checker.second - columnIndex
                    if (board[checker.first][columnIndex] != '_' && board[checker.first][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.LEFT))
                    }
                    break
                }
            }
            if(checker.first > 1 && checker.second > 1 && board[checker.first - 1][checker.second - 1] == opponent) {
                var rowIndex = checker.first - 1
                var columnIndex = checker.second - 1
                while(rowIndex >= 1 || columnIndex >= 1) {
                    while(board[rowIndex][columnIndex] == opponent) {
                        if (rowIndex != 0 && columnIndex != 0) {
                            rowIndex -= 1
                            columnIndex -= 1
                        } else break
                    }
                    val numberOfCoups = checker.first - rowIndex
                    if (board[rowIndex][columnIndex] != '_' && board[rowIndex][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.UP_LEFT))
                    }
                    break
                }
            }
            if(checker.first > 1 && checker.second < 7 && board[checker.first - 1][checker.second + 1] == opponent) {
                var rowIndex = checker.first - 1
                var columnIndex = checker.second + 1
                while(rowIndex > 0 || columnIndex < 8) {
                    while(board[rowIndex][columnIndex] == opponent) {
                        if(rowIndex != 0 && columnIndex != 7) {
                            rowIndex -= 1
                            columnIndex += 1
                        } else break
                    }
                    val numberOfCoups = checker.first - rowIndex
                    if (board[rowIndex][columnIndex] != '_' && board[rowIndex][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.UP_RIGHT))
                    }
                    break
                }
            }
            if(checker.first < 7 && checker.second > 1 && board[checker.first + 1][checker.second - 1] == opponent) {
                var rowIndex = checker.first + 1
                var columnIndex = checker.second - 1
                while(rowIndex < 8 || columnIndex > 0) {
                    while(board[rowIndex][columnIndex] == opponent) {
                        if(rowIndex != 7 && columnIndex != 0) {
                            rowIndex += 1
                            columnIndex -= 1
                        } else break
                    }
                    val numberOfCoups = rowIndex - checker.first
                    if (board[rowIndex][columnIndex] != '_' && board[rowIndex][columnIndex] != opponent) {
                        moveOption[checker]!!.add(Pair(numberOfCoups, Direction.DOWN_LEFT))
                    }
                    break
                }
            }
        }
        return moveOption
    }

    fun move2(board: Array<CharArray>, opponent: Char, player: Char) {
        val moveOption = move(board, opponent, player)
        val listMax = mutableMapOf<Pair<Int, Int>, Int>()
        for (i in moveOption) {
            var count = 0
            for (el in i.value) {
                count += el.first
            }
            listMax[i.key] = count
        }

        println(moveOption)
        if(!moveOption.isNullOrEmpty()) {
            val maxValue = listMax.maxBy { it.value }
            println(maxValue)
            if (maxValue!!.value != 0 ) {
                board[maxValue.key.first][maxValue.key.second] = player
                for (move in moveOption[maxValue.key]!!) {
                    if(move.second == Direction.DOWN_RIGHT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first + i][maxValue.key.second + i] = player
                        }
                    }
                    if(move.second == Direction.DOWN) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first + i][maxValue.key.second] = player
                        }
                    }
                    if(move.second == Direction.RIGHT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first][maxValue.key.second + i] = player
                        }
                    }
                    if(move.second == Direction.UP) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first - i][maxValue.key.second] = player
                        }
                    }
                    if(move.second == Direction.LEFT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first][maxValue.key.second - i] = player
                        }
                    }
                    if(move.second == Direction.UP_RIGHT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first - i][maxValue.key.second + i] = player
                        }
                    }
                    if(move.second == Direction.UP_LEFT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first - i][maxValue.key.second - i] = player
                        }
                    }
                    if(move.second == Direction.DOWN_LEFT) {
                        for (i in 1..move.first) {
                            board[maxValue.key.first + i][maxValue.key.second - i] = player
                        }
                    }
                }
                conditional = true
            } else conditional = false
        } else conditional = false
    }
}