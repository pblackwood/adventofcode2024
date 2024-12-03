package puzzles

import kotlin.io.path.Path
import kotlin.io.path.readLines

class Puzzle02(
    private val pathName: String,
    private var left: List<Int>? = emptyList(),
    private var right: List<Int>? = emptyList(),
) {
    fun main() {
        val arrays = readInputs(pathName)
        left = arrays.first.sorted()
        right = arrays.second.sorted()
        println(similarityScope(left!!, elementCounts(right!!)))
    }

    fun elementCounts(sortedArray: List<Int>): Map<Int, Int> {
        val counts: MutableMap<Int, Int> = mutableMapOf()
        for (num in sortedArray) {
            val count = counts[num] ?: 0
            counts[num] = count + 1
        }
        return counts
    }

    fun elementCount(
        element: Int,
        countMap: Map<Int, Int>,
    ): Int = countMap[element] ?: 0

    fun similarityScope(
        left: List<Int>,
        rightElementCounts: Map<Int, Int>,
    ): Int = left.fold(0) { sum, num -> sum + (num * elementCount(num, rightElementCounts)) }

    private fun readInputs(pathName: String): Pair<List<Int>, List<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        val inputs = Path(pathName).readLines()
        for (line in inputs) {
            val row = line.split(" ")
            left.add(row[0].toInt())
            right.add(row[3].toInt())
        }
        return Pair(left, right)
    }
}
