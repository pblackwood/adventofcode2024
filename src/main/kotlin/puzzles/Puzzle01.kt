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
    println(left.foldIndexed(0) { index, acc, value -> acc + abs(value - right[index]) })
}

fun readInputs(fileName: String) {
    val inputs = Path("/Users/peter/artisan/aoc2024/inputs/${fileName}").readLines()
    for (line in inputs) {
        val row = line.split(" ")
        left.add(row[0].toInt())
        right.add(row[3].toInt())
    }
}
