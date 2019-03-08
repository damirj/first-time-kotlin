package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {

    val file = File("dayTwo.txt")
    val values = file.readLines()

    var twoCount = 0
    var threeCount = 0
    var checksum: Int

    for (value in values) {
        threeCount += checkForThree(value)
        twoCount += checkForTwo(value)
    }

    checksum = threeCount * twoCount
    print(checksum)
}

fun checkForTwo(ID: String): Int {
    var count = 0
    for (i in ID) {
        for (j in ID) {
            if (i == j) {
                count += 1
            }
        }
        if (count == 2) {
            return 1
        }
        count = 0
    }
    return 0
}

fun checkForThree(ID: String): Int {
    var count = 0
    for (i in ID) {
        for (j in ID) {
            if (i == j) {
                count += 1
            }
        }
        if (count == 3) {
            return 1
        }
        count = 0
    }
    return 0
}