package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {

    val file = File("dayTwo.txt")
    val values = file.readLines()

    for (value in values) {
        for (it in values) {
            if (countDiff(value, it) == 1){
                println(commonLetters(value, it))
            }
        }
    }
}

fun countDiff(stringOne: String, stringTwo: String): Int {
    var difference = 0
    for (i in 0 until stringOne.length) {
        if (stringOne[i] != stringTwo[i]) {
            difference += 1
        }
    }
    return difference
}

fun commonLetters(stringOne: String, stringTwo: String): String {
    var common: String
    for (i in 0 until stringOne.length) {
        if(stringOne[i] != stringTwo[i]) {
            common = stringOne.substring(0,i) + stringOne.substring(i,stringOne.lastIndex)
            return common
        }
    }
    return "Error"
}