import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import Logic.Opponent
import kotlin.test.assertEquals

class Test {

    @Test
    @Tag("Easy")
    fun testMove() {
        val mop = Opponent()
        fun move2(): Int {

            val board = arrayOf(
                charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
                charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
                charArrayOf('_', '_', '_', 'W', '_', '_', '_', '_'),
                charArrayOf('_', '_', '_', 'W', 'W', '_', '_', '_'),
                charArrayOf('_', '_', '_', 'W', 'B', '_', '_', '_'),
                charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
                charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
                charArrayOf('_', '_', '_', '_', '_', '_', '_', '_')
            )
            val listMax = mutableMapOf<Pair<Int, Int>, Int>()
            val moveOption = mop.move(board, 'W', 'B')
            for (i in moveOption) {
                var count = 0
                for (el in i.value) {
                    count += el.first
                }
                listMax[i.key] = count
            }
            println(mop.move(board, 'B', 'W'))
            println(listMax)
            println(listMax.maxBy { it.value })
            val result = listMax.maxBy { it.value }
            return result!!.value
        }
        assertEquals(2, move2())
    }
}