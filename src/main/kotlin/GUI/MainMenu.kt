package GUI

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.input.KeyEvent
import javafx.scene.text.FontWeight
import tornadofx.*
import java.net.URI


var name = ""
class MainMenu : Fragment("Reversi") {
    override val root = borderpane {
        primaryStage.isResizable = false
        val nameS = SimpleStringProperty()
        style {
            backgroundImage = multi(URI("/Pictures/reversiV2.jpg"))
        }
        setPrefSize(800.0, 600.0)
        setMaxSize(800.0, 600.0)
        setMinSize(800.0, 600.0)
        var buttonStart: Button by singleAssign()
        center {
            vbox {
                translateY = 122.5 // отступ слева направо внутреннего контейнера, который содержит кнопки меню
                setPrefSize(200.0, minHeight)
                setMaxSize(200.0, minHeight)
                setMinSize(200.0, minHeight)

                label("Главное меню") {
                    translateX = -100.0
                    translateY = -50.0 // смещение для лейбла "Главное меню"
                    setPrefSize(400.0, 50.0)
                    setMaxSize(400.0, 50.0)
                    setMinSize(400.0, 50.0)
                    alignment = Pos.CENTER
                    style {
                        fontSize = 46.px
                        fontWeight = FontWeight.BOLD
                    }
                }
                vbox {
                    label("Имя Игрока") {
                        translateY = -5.0
                        style {
                            fontWeight = FontWeight.BOLD
                        }
                    }
                    textfield(nameS) {
                        setPrefSize(200.0, 25.0)
                        setMaxSize(200.0, 25.0)
                        setMinSize(200.0, 25.0)
                        promptText = "Введите никнейм"
                        addEventFilter(KeyEvent.ANY) {
                            println(nameS.value)
                            buttonStart.isDisable = !(nameS.value != "" && nameS.value != null)
                        }
                    }
                    buttonStart = button("Играть") {
                        translateY = 15.0
                        isDisable = true
                        setPrefSize(200.0, 50.0)
                        setMaxSize(200.0, 50.0)
                        setMinSize(200.0, 50.0)
                        action {
                            name = nameS.value
                            close()
                            val window = find<PlayingField>()
                            window.openWindow()
                            window.currentStage!!.isResizable = false
                        }
                    }
                }

                button("Статистика") {

                    translateY = 30.0
                    setPrefSize(200.0, 50.0)
                    setMaxSize(200.0, 50.0)
                    setMinSize(200.0, 50.0)
                    action {
                        close()
                        val window = find<Records>()
                        window.openWindow()
                        window.currentStage!!.isResizable = false
                    }
                }

                button("Справка") {
                    translateY = 45.0
                    setPrefSize(200.0, 50.0)
                    setMaxSize(200.0, 50.0)
                    setMinSize(200.0, 50.0)
                    action {
                        close()
                        val window = find<Help>()
                        window.openWindow()
                        window.currentStage!!.isResizable = false
                    }
                }
            }
        }
    }
}
