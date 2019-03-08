package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {
    val file = File("dayOne.txt")
    val values = file.readLines()

    var sum = 0
    val frequency = mutableSetOf<Int>(0)


    loop@ while(true){
        for (value in values) {
            sum += value.toInt()
            if(frequency.contains(sum)){
                print(sum)
                break@loop
            }
            frequency.add(sum)
        }
    }

}
