package GUI

import javafx.stage.Stage
import tornadofx.App

    class Main: App(MainMenu::class) {
        override val primaryView = MainMenu::class


        override fun start(stage: Stage) {
            stage.isResizable = false
            super.start(stage)
        }

    }
