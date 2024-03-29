package GUI

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class Help : View("My View") {
    override val root = anchorpane {
        setPrefSize(800.0, 700.0)
        setMaxSize(800.0, 700.0)
        setMinSize(800.0, 700.0)
        vbox {
            label("Правила игры") {
                translateX = 300.0
                setPrefSize(200.0, 50.0)
                setMaxSize(200.0, 50.0)
                setMinSize(200.0, 50.0)
                alignment = Pos.CENTER
                style {
                    fontSize = 24.px
                    fontWeight = FontWeight.BOLD
                }
            }
            textarea("В игре используется квадратная доска размером 8х8 (все клетки могут быть одного цвета) и 64\n" +
                    "специальные фишки, окрашенные с разных сторон в контрастные цвета,\n " +
                    "например, в белый и чёрный. Клетки доски нумеруются от верхнего левого угла: вертикали - латинскими буквами,\n" +
                    " горизонтали - цифрами. Один из игроков играет белыми, другой - чёрными.\n" +
                    " Делая ход, игрок ставит фишку на клетку доски \"своим\" цветом вверх.\n" +
                    "В начале игры в центр доски выставляются 4 фишки: чёрные на d5 и e4, белые \n" +
                    "на d4 и e5. Первый ход делают чёрные. Далее игроки ходят по очереди.\n" +
                    "Делая ход, игрок должен поставить свою фишку на одну из клеток доски таким образом,\n" +
                    " чтобы между этой поставленной фишкой и одной из имеющихся уже на доске фишек его \n " +
                    "цвета находился непрерывный ряд фишек соперника, горизонтальный, вертикальный или \n" +
                    "диагональный (другими словами, чтобы непрерывный ряд фишек соперника оказался \"закрыт\"\n" +
                    " фишками игрока с двух сторон). Все фишки соперника, входящие в \"закрытый\" на этом ходу ряд,\n" +
                    " переворачиваются на другую сторону (меняют цвет) и переходят к ходившему игроку.\n" +
                    "Если в результате одного хода закрывается одновременно более одного ряда фишек противника,\n" +
                    " то переворачиваются все фишки, оказавшиеся на всех \"закрытых\" рядах.\n" +
                    "Игрок вправе выбирать любой из возможных для него ходов. Если игрок имеет возможные ходы,\n" +
                    " он не может отказаться от хода. Если игрок не имеет допустимых ходов, то ход передаётся сопернику.\n" +
                    "Игра прекращается, когда на доску выставлены все фишки или когда ни один из игроков не может сделать \n" +
                    "хода. По окончании игры проводится подсчёт фишек каждого цвета, и игрок, чьих фишек на доске выставлено\n" +
                    " больше, объявляется победителем. В случае равенства количества фишек засчитывается ничья.")
            {
                translateX = 100.0
                setPrefSize(600.0, 575.0)
                setMaxSize(600.0, 575.0)
                setMinSize(600.0, 575.0)
                isWrapText = true
                isDisable = false
                isEditable = false
            }

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
    }
}
