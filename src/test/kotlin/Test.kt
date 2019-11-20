import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import Logic.Opponent
import kotlin.test.assertEquals

class Test {

    private val boardTest1 = arrayOf(
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', 'W', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', 'W', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', 'W', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', 'B', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_')
    )

    private val boardTest2 = arrayOf(
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', 'W', '_', '_', '_'),
        charArrayOf('_', '_', '_', 'W', 'B', 'W', 'W', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_')
    )

    private val boardTest3 = arrayOf(
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', 'W', '_'),
        charArrayOf('_', '_', '_', 'W', '_', '_', 'W', '_'),
        charArrayOf('_', '_', '_', 'W', 'W', '_', 'W', '_'),
        charArrayOf('_', 'W', 'W', 'W', 'B', 'W', 'W', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', 'B', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_'),
        charArrayOf('_', '_', '_', '_', '_', '_', '_', '_')
    )

    private val mop = Opponent()
    private fun move2(board: Array<CharArray>): Int {

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
    @Test
    @Tag("Easy")
    fun testMove1() {
        assertEquals(4, move2(boardTest1))
    }


    @Test
    @Tag("Easy")
    fun testMove2() {
        assertEquals(3, move2(boardTest2))
    }

    @Test
    @Tag("Easy")
    fun testMove3() {
        assertEquals(5, move2(boardTest3))
    }
}
