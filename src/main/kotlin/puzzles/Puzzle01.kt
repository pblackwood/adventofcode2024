package puzzles

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs

val left: MutableList<Int> = emptyList<Int>().toMutableList()
val right: MutableList<Int> = emptyList<Int>().toMutableList()

fun main() {
    readInputs("Day01.txt")
    left.sort()
    right.sort()
    var result = 0
    left.forEachIndexed { index, value ->
        result += abs(value - right[index])
//        println("$index $value ${right[index]} ${abs(value - right[index])}")
    }
    println(result)
}

fun readInputs(fileName: String) {
    val inputs = Path("/Users/peter/artisan/aoc2024/inputs/${fileName}").readLines()
    for (line in inputs) {
        val row = line.split(" ")
        left.add(row[0].toInt())
        right.add(row[3].toInt())
    }
}
