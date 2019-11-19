package GUI

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*
import java.io.File

class Finish : Fragment("Finish") {
    override val root = anchorpane {
        setPrefSize(800.0, 600.0)
        setMaxSize(800.0, 600.0)
        setMinSize(800.0, 600.0)
        vbox {
            label("GAME OVER") {
                setPrefSize(400.0, 200.0)
                setMaxSize(400.0, 200.0)
                setMinSize(400.0, 200.0)
                alignment = Pos.CENTER
                translateX = 200.0
                translateY = 50.0
                style {
                    fontSize = 40.px
                    fontWeight = FontWeight.EXTRA_BOLD
                }
            }
            hbox {
                vbox {
                    translateX = 200.0
                    label(name) {
                        setPrefSize(150.0, 75.0)
                        setMaxSize(150.0, 75.0)
                        setMinSize(150.0, 75.0)
                        alignment = Pos.CENTER
                        style {
                            fontSize = 36.px
                            fontWeight = FontWeight.EXTRA_BOLD
                        }
                    }

                    label(playerFP) {
                        setPrefSize(150.0, 75.0)
                        setMaxSize(150.0, 75.0)
                        setMinSize(150.0, 75.0)
                        alignment = Pos.TOP_CENTER
                        style {
                            fontSize = 36.px
                            fontWeight = FontWeight.EXTRA_BOLD
                        }
                    }
                }
                vbox {
                    translateX = 300.0
                    label("Player2") {
                        setPrefSize(150.0, 75.0)
                        setMaxSize(150.0, 75.0)
                        setMinSize(150.0, 75.0)
                        alignment = Pos.CENTER
                        style {
                            fontSize = 36.px
                            fontWeight = FontWeight.EXTRA_BOLD
                        }
                    }

                    label(playerSP) {
                        setPrefSize(150.0, 75.0)
                        setMaxSize(150.0, 75.0)
                        setMinSize(150.0, 75.0)
                        alignment = Pos.TOP_CENTER
                        style {
                            fontSize = 36.px
                            fontWeight = FontWeight.EXTRA_BOLD
                        }
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
                        writeFile()
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
                        writeFile()
                        close()
                    }
                }
            }
        }
    }

    private fun writeFile() {
        val listOfRecords = mutableListOf<Pair<String, Int>>()
        var input = listOf<String>()
        if (File("records").exists()) {
             input = File("records").readLines()
        } else File("records").createNewFile()
        //println(input)
        for (i in input) {
            val parts = i.split(" ")
            listOfRecords.add(Pair(parts[0], parts[1].toInt()))
        }
        listOfRecords.add(Pair(name, playerFP.toInt()))
        val out = File("records").bufferedWriter()
        for (i in listOfRecords.sortedBy { it.second }) {
            out.write("${i.first} ${i.second}")
            out.newLine()
        }
        out.close()
    }
}
