package GUI

import Event.OpponentEvent
import Logic.Board
import Logic.Opponent
import Logic.conditional
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.paint.Paint
import tornadofx.*
import java.net.URI
import kotlin.random.Random

var playerFP = "" // очки игрока
var playerSP = "" // очки бота
class PlayingField : Fragment("Reversi") {
    private val opponentMoves = Opponent()


    override val root = anchorpane {
        setPrefSize(800.0, 600.0)
        setMaxSize(800.0, 600.0)
        setMinSize(800.0, 600.0)
        vbox {
            setPrefSize(800.0, 600.0)
            setMaxSize(800.0, 600.0)
            setMinSize(800.0, 600.0)
            var player1: Label by singleAssign()
            var player2: Label by singleAssign()
            var player1Button: Button by singleAssign()
            var player2Button: Button by singleAssign()
            anchorpane {
                hbox {
                    vbox {
                        translateX = 180.0
                        style {
                            backgroundColor = multi(Paint.valueOf("000000")) // черный цвет
                        }
                        hbox {
                            player1 = label("0") {
                                translateX = -10.0
                                style {
                                    textFill = Paint.valueOf("FFFFFF") // белый цвет
                                    fontSize = 24.px
                                }
                                setPrefSize(150.0, 50.0)
                                setMaxSize(150.0, 50.0)
                                setMinSize(150.0, 50.0)
                                alignment = Pos.CENTER_RIGHT
                            }
                            anchorpane {
                                setPrefSize(50.0, 50.0)
                                setMaxSize(50.0, 50.0)
                                setMinSize(50.0, 50.0)
                                style {
                                    backgroundImage = multi(URI("/Pictures/whiteV2.png"))
                                }
                            }
                        }
                        hbox {
                            label(name) {
                                style {
                                    textFill = Paint.valueOf("FFFFFF")
                                    fontSize = 24.px
                                }
                                setPrefSize(150.0, 50.0)
                                setMaxSize(150.0, 50.0)
                                setMinSize(150.0, 50.0)
                                alignment = Pos.CENTER
                            }
                            anchorpane {

                                setPrefSize(50.0, 50.0)
                                setMaxSize(50.0, 50.0)
                                setMinSize(50.0, 50.0)

                                player1Button = button {
                                    translateX = 10.0
                                    translateY = 10.0
                                    setPrefSize(30.0, 30.0)
                                    setMaxSize(30.0, 30.0)
                                    setMinSize(30.0, 30.0)
                                    style {
                                        backgroundColor = multi(Paint.valueOf("#00e676")) // светофор (чей ход) зеленый
                                        shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 " // изменение стандартной кнопки в круглую форму
                                    }
                                }
                            }
                        }
                    }
                    vbox {
                        style {
                            backgroundColor = multi(Paint.valueOf("000000"))
                        }
                        translateX = 220.0
                        hbox {
                            anchorpane {
                                setPrefSize(50.0, 50.0)
                                setMaxSize(50.0, 50.0)
                                setMinSize(50.0, 50.0)
                                style {
                                    backgroundImage = multi(URI("/Pictures/blackV2.png"))
                                }
                            }
                            player2 = label("0") {
                                translateX = 10.0
                                style {
                                    textFill = Paint.valueOf("FFFFFF")
                                    fontSize = 24.px
                                }
                                setPrefSize(150.0, 50.0)
                                setMaxSize(150.0, 50.0)
                                setMinSize(150.0, 50.0)
                                alignment = Pos.CENTER_LEFT
                            }
                        }
                        hbox {
                            anchorpane {
                                setPrefSize(50.0, 50.0)
                                setMaxSize(50.0, 50.0)
                                setMinSize(50.0, 50.0)

                                player2Button = button {
                                    translateX = 10.0
                                    translateY = 10.0
                                    setPrefSize(30.0, 30.0)
                                    setMaxSize(30.0, 30.0)
                                    setMinSize(30.0, 30.0)
                                    style {
                                        backgroundColor = multi(Paint.valueOf("#f44336")) // красный
                                        shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 "
                                    }
                                }
                            }

                            label("Player2") {
                                style {
                                    textFill = Paint.valueOf("FFFFFF")
                                    fontSize = 24.px
                                }
                                setPrefSize(150.0, 50.0)
                                setMaxSize(150.0, 50.0)
                                setMinSize(150.0, 50.0)
                                alignment = Pos.CENTER
                            }
                        }
                    }
                }
            }

            vbox {
                var check = true
                translateY = 25.0
                translateX = 200.0

                val arrayOfButton = arrayOf(
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button()),
                    arrayListOf(Button(), Button(), Button(), Button(), Button(), Button() , Button(), Button())

                )

                fun parse(): Pair<Int, Int> {
                    var white = 0
                    var black = 0
                    for (line in arrayOfButton) {
                        for (button in line) {
                            if(button.style.length > 90) {
                                val part = button.style.toString().split(Regex("""/Pictures/"""))
                                val playerColor = part[1]
                                if(playerColor == "blackV2.png\");") black += 1
                                if(playerColor == "whiteV2.png\");") white += 1
                            }
                        }
                    }
                    return Pair(white, black)
                }

                val boardField = Board(arrayOf())
                boardField.boardFillUp()
                val playerBoard = Opponent()


                fun reMakeTable() {
                    for (line in 0 until 8) {
                        for (elements in 0 until 8) {
                            if(boardField.board[line][elements] == 'W') {
                                arrayOfButton[line][elements].style {
                                    backgroundColor = if (line % 2 == 0 && elements % 2 == 0 || line % 2 != 0 && elements % 2 != 0)
                                        multi(Paint.valueOf("#feffd9"))
                                    else multi(Paint.valueOf("#5e1919"))
                                    backgroundImage = multi(URI("/Pictures/whiteV2.png"))
                                    //arrayOfButton[line][elements].action { println("GOOD") }
                                }
                            }
                            if(boardField.board[line][elements] == 'B') {
                                arrayOfButton[line][elements].style {
                                    if (line % 2 == 0 && elements % 2 == 0 || line % 2 != 0 && elements % 2 != 0)
                                        backgroundColor = multi(Paint.valueOf("#feffd9"))
                                    else backgroundColor = multi(Paint.valueOf("#5e1919"))
                                    backgroundImage = multi(URI("/Pictures/blackV2.png"))
                                }
                            }
                        }
                    }
                }
                //board = arrayOf(
                //    charArrayOf('_','_','_','_','_','_','_','_'),
                //    charArrayOf('_','_','_','_','_','_','_','_'),
                //    charArrayOf('_','_','_','_','_','_','_','_'),
                //    charArrayOf('_','_','_','B','W','_','_','_'),
                //    charArrayOf('_','_','_','W','B','_','_','_'),
                //    charArrayOf('_','_','_','_','_','_','_','_'),
                //    charArrayOf('_','_','_','_','_','_','_','_'),
                //    charArrayOf('_','_','_','_','_','_','_','_')
                //)

                subscribe<OpponentEvent> {
                    opponentMoves.move2(it.board, it.opponent, it.player)
                    if (conditional) {
                        reMakeTable()
                        check = true
                        player1Button.style {
                            backgroundColor = multi(Paint.valueOf("#00e676"))
                            shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 "
                        }
                        player2Button.style {
                            backgroundColor = multi(Paint.valueOf("#f44336"))
                            shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 "
                        }
                        val helpBoard = playerBoard.move(it.board, it.player, it.opponent)
                        for (line in arrayOfButton) {
                            for (button in line) {
                                if(button.style.length < 90) {
                                    button.isDisable = true
                                }
                            }
                        }
                        for (position in helpBoard) {
                            if(arrayOfButton[position.key.first][position.key.second].style.length < 90) {
                                arrayOfButton[position.key.first][position.key.second].isDisable = position.value.isEmpty()
                            }
                        }
                        for (line in arrayOfButton) {
                            for (button in line) {
                                if (button.style.length > 90) {
                                    button.isDisable = false
                                }
                            }
                        }
                        player1.text = (parse().first).toString()
                        player2.text = (parse().second).toString()

                        if (parse().first + parse().second == 64 || parse().first == 0 || parse().second == 0)  {
                            playerFP = parse().first.toString()
                            playerSP = parse().second.toString()
                            close()
                            find<Finish>().openWindow()
                        }
                    } else {
                        player1Button.style {
                            backgroundColor = multi(Paint.valueOf("#00e676"))
                            shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300"
                        }
                        player2Button.style {
                            backgroundColor = multi(Paint.valueOf("#f44336"))
                            shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300"
                        }
                        val helpBoard = playerBoard.move(it.board, it.player, it.opponent)
                        for (line in arrayOfButton) {
                            for (button in line) {
                                if(button.style.length < 90) {
                                    button.isDisable = true
                                }
                            }
                        }
                        for (position in helpBoard) {
                            if(arrayOfButton[position.key.first][position.key.second].style.length < 90) {
                                arrayOfButton[position.key.first][position.key.second].isDisable = position.value.isEmpty()
                            }
                        }
                        for (line in arrayOfButton) {
                            for (button in line) {
                                if (button.style.length > 90) {
                                    button.isDisable = false
                                }
                            }
                        }
                        check = true
                    }
                }


                for (line in 0 until boardField.board.size) {
                    hbox {
                        for (element in 0 until boardField.board[line].size) {
                            val buttonBoard = button {
                                isDisable = true
                                // #feffd9  беж
                                // #5e1919 борд
                                style {
                                    if (line % 2 == 0 && element % 2 == 0 || line % 2 != 0 && element % 2 != 0)
                                        backgroundColor = multi(Paint.valueOf("#feffd9"))
                                    else backgroundColor = multi(Paint.valueOf("#5e1919"))
                                }
                                setPrefSize(50.0, 50.0)
                                setMinSize(50.0, 50.0)
                                setMaxSize(50.0, 50.0)

                                if (line == 3 && element == 3 || line == 4 && element == 4) { // начлаьные позиции фишек черных
                                    isDisable = false
                                    style {
                                        backgroundColor = multi(Paint.valueOf("#feffd9"))
                                        backgroundImage = multi(URI("/Pictures/blackV2.png"))
                                    }
                                }
                                if (line == 4 && element == 3 || line == 3 && element == 4) { // начальные позиции фишек белых
                                    isDisable = false
                                    style {
                                        backgroundColor = multi(Paint.valueOf("#5e1919"))
                                        backgroundImage = multi(URI("/Pictures/whiteV2.png"))
                                    }
                                }
                                action {
                                    if (style.length < 90) { // если < 90 то клетка пустая если > 90 то с фишкой
                                        if (check) { // true - white // false - black
                                            style {
                                                backgroundColor = if (line % 2 == 0 && element % 2 == 0 || line % 2 != 0 && element % 2 != 0)
                                                    multi(Paint.valueOf("#feffd9"))
                                                else multi(Paint.valueOf("#5e1919"))
                                                backgroundImage = multi(URI("/Pictures/whiteV2.png"))
                                            }
                                            check = false
                                            boardField.checkPoint(line, element, 'B', 'W')
                                            reMakeTable()
                                            player1Button.style {
                                                backgroundColor = multi(Paint.valueOf("#f44336"))
                                                shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 "
                                            }
                                            player2Button.style {
                                                backgroundColor = multi(Paint.valueOf("#00e676"))
                                                shape = "M 200 300 A 50 50 0 1 1 350 300 A 50 50 0 1 1 200 300 "
                                            }
                                            runLater(Random.nextDouble(0.3, 1.0).seconds) {
                                                fire(OpponentEvent('W', boardField.board, 'B'))
                                            }
                                        }
                                    }
                                    player1.text = (parse().first).toString()
                                    player2.text = (parse().second).toString()
                                    if (parse().first + parse().second == 64 || parse().first == 0 || parse().second == 0)  {
                                        playerFP = parse().first.toString()
                                        playerSP = parse().second.toString()
                                        close()
                                        find<Finish>().openWindow()
                                    }
                                }
                            }
                            arrayOfButton[line][element] = buttonBoard
                        }
                    }
                }
                val playerHelp = playerBoard.move(boardField.board, 'B', 'W' )
                for (position in playerHelp) {
                    if(arrayOfButton[position.key.first][position.key.second].style.length < 90) {
                        arrayOfButton[position.key.first][position.key.second].isDisable = position.value.isEmpty()
                    }
                }
            }

            hbox {
                translateY = 65.0
                translateX = 450.0
                button("Главное меню") {
                    setPrefSize(150.0, 25.0)
                    setMaxSize(150.0, 25.0)
                    setMinSize(150.0, 25.0)
                    action {
                        close()
                        find<MainMenu>().openWindow()
                    }

                }
                button("Выход") {
                    translateX = 25.0
                    setPrefSize(150.0, 25.0)
                    setMaxSize(150.0, 25.0)
                    setMinSize(150.0, 25.0)
                    action {
                        close()
                    }
                }
            }
        }
    }
}
