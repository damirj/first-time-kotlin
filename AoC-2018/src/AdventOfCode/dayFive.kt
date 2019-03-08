package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {
    val file = File("dayFive.txt")
    val value = file.readText()

    var polymer = Polymer(value)
    //Part One
    polymer.fullReaction()
    println(polymer.tempPolymer.length)

    //Part Two
    var letter = 'A'
    var polymerLenght = mutableListOf<Int>()
    while (letter <= 'Z') {
        polymer.removeChar(letter)
        polymer.fullReaction()
        polymerLenght.add(polymer.tempPolymer.length)
        ++letter
    }
    println(polymerLenght.min())

}

class Polymer (val inputString: String) {

    var tempPolymer = inputString

    fun fullReaction() {
        var k = 0
        for (j in 0..25000) {
           loop@ for (i in k until tempPolymer.length) {
                if (checkPolarity(tempPolymer.getOrNull(i), tempPolymer.getOrNull(i+1))) {
                    tempPolymer = tempPolymer.substring(0, i) + tempPolymer.substring(i+2)
                    if (i > 6) {
                        k = i-6
                    }
                    break@loop
                }
            }
        }
    }

    fun checkPolarity(charOne: Char?, charTwo: Char?): Boolean {
        if (charTwo == null){
            return false
        }
        if (charOne!!.toInt() > charTwo.toInt()) {
            return (charOne.toInt() - 32 == charTwo.toInt())
        }else if (charOne.toInt() < charTwo.toInt()) {
            return (charOne.toInt() == charTwo.toInt() - 32)
        }else {
            return false
        }
    }

    fun removeChar(charUpperCase: Char) {
        tempPolymer = inputString.replace(charUpperCase.toString(), "")
        tempPolymer = tempPolymer.replace((charUpperCase.toInt() + 32).toChar().toString(), "")

    }
}