package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {
    val file = File("dayOne.txt")
    val values = file.readLines()

    var sum = 0

    values.forEach { value ->
        sum += value.toInt()
    }

    print(sum)

}