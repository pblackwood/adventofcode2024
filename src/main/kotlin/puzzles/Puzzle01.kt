package puzzles

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs

class Puzzle01(
    pathName: String,
) {
    private val arrays: Pair<MutableList<Int>, MutableList<Int>> = readInputs(pathName)
    private val left: MutableList<Int> = arrays.first.sorted().toMutableList()
    private val right: MutableList<Int> = arrays.second.sorted().toMutableList()

    fun main() {
        println(totalDistance())
    }

    private fun totalDistance() {
        println(this.left.foldIndexed(0) { index, acc, value -> acc + abs(value - this.right[index]) })
    }

    private fun readInputs(pathName: String): Pair<MutableList<Int>, MutableList<Int>> {
        val left = emptyList<Int>().toMutableList()
        val right = emptyList<Int>().toMutableList()
        val inputs = Path(pathName).readLines()
        for (line in inputs) {
            val row = line.split(" ")
            left.add(row[0].toInt())
            right.add(row[3].toInt())
        }
        return Pair(left, right)
    }
}
