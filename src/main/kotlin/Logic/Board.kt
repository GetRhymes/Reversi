package Logic
// возможный текущий ход
class Board(var board: Array<CharArray>) {

    fun boardFillUp() {
        board = arrayOf(
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
            charArrayOf('_', '_', '_', 'B', 'W', '_', '_', '_'),
            charArrayOf('_', '_', '_', 'W', 'B', '_', '_', '_'),
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
            charArrayOf('_', '_', '_', '_', '_', '_', '_', '_')
        )
    }
    fun checkPoint(rowIndex: Int, columnIndex: Int, opponent: Char, player: Char) {
        board[rowIndex][columnIndex] = player
        if(rowIndex < 7 && columnIndex < 7 && board[rowIndex + 1][columnIndex + 1] == opponent) {
            var rowIndexOp = rowIndex + 1
            var columnIndexOp = columnIndex + 1
            while(rowIndexOp < 8 || columnIndexOp < 8) {
                while(board[rowIndexOp][columnIndexOp] == opponent) {
                    if(rowIndexOp != 7 && columnIndexOp != 7) {
                        rowIndexOp += 1
                        columnIndexOp += 1
                    } else break
                }
                val countRow = rowIndexOp - rowIndex
                if (board[rowIndexOp][columnIndexOp] != '_' && board[rowIndexOp][columnIndexOp] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex + i][columnIndex + i] = player
                    }
                }
                break
            }
        }
        if(rowIndex < 7 && board[rowIndex + 1][columnIndex] == opponent) {
            var rowIndexOp = rowIndex + 1
            while(rowIndexOp < 8) {
                while(board[rowIndexOp][columnIndex] == opponent) {
                    if(rowIndexOp != 7) {
                        rowIndexOp += 1
                    } else break
                }
                val countRow = rowIndexOp - rowIndex
                if (board[rowIndexOp][columnIndex] != '_' && board[rowIndexOp][columnIndex] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex + i][columnIndex] = player
                    }
                }
                break
            }
        }
        if(columnIndex < 7 && board[rowIndex][columnIndex + 1] == opponent) {
            var columnIndexOp = columnIndex + 1
            while(columnIndexOp < 8) {
                while(board[rowIndex][columnIndexOp] == opponent) {
                    if (columnIndexOp != 7) {
                        columnIndexOp += 1
                    } else break
                }
                val countColumn = columnIndexOp - columnIndex
                if (board[rowIndex][columnIndexOp] != '_' && board[rowIndex][columnIndexOp] != opponent) {
                    for (i in 1..countColumn) {
                        board[rowIndex][columnIndex + i] = player
                    }
                }
                break
            }
        }
        if(rowIndex > 1 && board[rowIndex - 1][columnIndex] == opponent) {
            var rowIndexOp = rowIndex - 1
            while(rowIndexOp > 0) {
                while(board[rowIndexOp][columnIndex] == opponent) {
                    if(rowIndexOp != 0) {
                        rowIndexOp -= 1
                    } else break
                }
                val countRow = rowIndex - rowIndexOp
                if (board[rowIndexOp][columnIndex] != '_' && board[rowIndexOp][columnIndex] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex - i][columnIndex] = player
                    }
                }
                break
            }
        }
        if(columnIndex > 1 && board[rowIndex][columnIndex -  1] == opponent) {
            var columnIndexOp = columnIndex - 1
            while(columnIndexOp > 0) {
                while(board[rowIndex][columnIndexOp] == opponent) {
                    if(columnIndexOp != 0) {
                        columnIndexOp -= 1
                    } else break
                }
                val countColumn = columnIndex - columnIndexOp
                if (board[rowIndex][columnIndexOp] != '_' && board[rowIndex][columnIndexOp] != opponent) {
                    for (i in 1..countColumn) {
                        board[rowIndex][columnIndex - i] = player
                    }
                }
                break
            }
        }
        if(rowIndex > 1 && columnIndex > 1 && board[rowIndex - 1][columnIndex - 1] == opponent) {
            var rowIndexOp = rowIndex - 1
            var columnIndexOp = columnIndex - 1
            while(rowIndexOp >= 1 || columnIndexOp >= 1) {
                while(board[rowIndexOp][columnIndexOp] == opponent) {
                    if (rowIndexOp != 0 && columnIndexOp != 0) {
                        rowIndexOp -= 1
                        columnIndexOp -= 1
                    } else break
                }
                val countRow = rowIndex - rowIndexOp
                if (board[rowIndexOp][columnIndexOp] != '_' && board[rowIndexOp][columnIndexOp] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex - i][columnIndex - i] = player
                    }
                }
                break
            }
        }
        if(rowIndex > 1 && columnIndex < 7 && board[rowIndex - 1][columnIndex + 1] == opponent) {
            var rowIndexOp = rowIndex - 1
            var columnIndexOp = columnIndex + 1
            while(rowIndexOp > 0 || columnIndexOp < 8) {
                while(board[rowIndexOp][columnIndexOp] == opponent) {
                    if(rowIndexOp != 0 && columnIndexOp != 7) {
                        rowIndexOp -= 1
                        columnIndexOp += 1
                    } else break
                }
                val countRow = rowIndex - rowIndexOp
                if (board[rowIndexOp][columnIndexOp] != '_' && board[rowIndexOp][columnIndexOp] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex - i][columnIndex + i] = player
                    }
                }
                break
            }
        }
        if(rowIndex < 7 && columnIndex > 1 && board[rowIndex + 1][columnIndex - 1] == opponent) {
            var rowIndexOp = rowIndex + 1
            var columnIndexOp = columnIndex - 1
            while(rowIndexOp < 8 || columnIndexOp > 0) {
                while(board[rowIndexOp][columnIndexOp] == opponent) {
                    if(rowIndexOp != 7 && columnIndexOp != 0) {
                        rowIndexOp += 1
                        columnIndexOp -= 1
                    } else break
                }
                val countRow = rowIndexOp - rowIndex
                if (board[rowIndexOp][columnIndexOp] != '_' && board[rowIndexOp][columnIndexOp] != opponent) {
                    for (i in 1..countRow) {
                        board[rowIndex + i][columnIndex - i] = player
                    }
                }
                break
            }
        }
        for (i in board) {
            println(i)
        }
    }
}