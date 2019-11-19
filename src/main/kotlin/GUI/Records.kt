package GUI

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*
import java.io.File

class Records : Fragment("Статистика") {
    override val root = gridpane {
        setPrefSize(600.0,600.0)
        setMaxSize(600.0,600.0)
        setMinSize(600.0,600.0)
        var rec = listOf<String>()
        if (File("records").exists()) {
            rec = File("records").readLines()
        } else File("records").createNewFile()

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(0,0)
            }
            setPrefSize(200.0,50.0)
            setMaxSize(200.0,50.0)
            setMinSize(200.0,50.0)

            label("Номер") {
                setPrefSize(200.0,50.0)
                setMaxSize(200.0,50.0)
                setMinSize(200.0,50.0)
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 24.px
                }
                alignment = Pos.CENTER
            }
        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(1,0)
            }
            setPrefSize(200.0,50.0)
            setMaxSize(200.0,50.0)
            setMinSize(200.0,50.0)

            label("Участники") {
                setPrefSize(200.0,50.0)
                setMaxSize(200.0,50.0)
                setMinSize(200.0,50.0)
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 24.px
                }
                alignment = Pos.CENTER
            }
        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(2,0)
            }
            setPrefSize(200.0,50.0)
            setMaxSize(200.0,50.0)
            setMinSize(200.0,50.0)

            label("Счет") {
                setPrefSize(200.0,50.0)
                setMaxSize(200.0,50.0)
                setMinSize(200.0,50.0)
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 24.px
                }
                alignment = Pos.CENTER
            }
        }

        anchorpane {

            gridpaneConstraints {
                columnRowIndex(0,1)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)
            vbox {
                for (i in 0 until rec.size) {
                    label("${i + 1}") {
                        translateX = 100.0
                        style {
                            fontWeight = FontWeight.BOLD
                            fontSize = 24.px
                        }
                        alignment = Pos.CENTER
                    }
                }
            }
        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(1,1)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)

            vbox {
                for (i in rec.size - 1 downTo 0) {
                    val me = rec[i].split(" ")
                    label(me[0]) {
                        translateX = 85.0
                        style {
                            fontWeight = FontWeight.BOLD
                            fontSize = 24.px
                        }
                        alignment = Pos.CENTER
                    }
                }
            }
        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(2,1)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)

            vbox {
                for (i in rec.size - 1 downTo 0) {
                    val me = rec[i].split(" ")
                    label(me[1]) {
                        translateX = 85.0
                        style {
                            fontWeight = FontWeight.BOLD
                            fontSize = 24.px
                        }
                        alignment = Pos.CENTER
                    }
                }
            }
        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(0,2)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)

            button("Назад") {
                setPrefSize(200.0, 30.0)
                setMaxSize(200.0, 30.0)
                setMinSize(200.0, 30.0)
                translateX = 50.0
                translateY  = 25.0
                action {
                    close()
                    val window = find<MainMenu>()
                    window.openWindow()
                    window.currentStage!!.isResizable = false
                }
            }

        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(1,2)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)

        }

        anchorpane {
            gridpaneConstraints {
                columnRowIndex(2,2)
            }
            setPrefSize(200.0, minHeight)
            setMaxSize(200.0, minHeight)
            setMinSize(200.0, minHeight)

        }

    }
}
