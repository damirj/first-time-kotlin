package AdventOfCode2018

import java.io.File

fun main(args: Array<String>) {

    val file = File("dayThree.txt")
    val values = file.readLines()

    val fabrics: MutableList<Fabric> = mutableListOf<Fabric>()
    val square = SquareBoard()

    for ((i,value) in values.withIndex()) {
        fabrics.add(Fabric(value))
        square.putFabric(fabrics[i])
    }

    square.overlapFabric()
    square.perfectFabric(fabrics)
}

class SquareBoard() {
    val sizeX = 1200
    val sizeY = 1200
    val board = Array(sizeY) {Array(sizeX) {0} }

    fun putFabric(fab: Fabric){
        // Inserting given fabric on square board
        // AdventOfCode2018.Fabric placement is noted with fabric id
        // AdventOfCode2018.Fabric overlapping is noted with '-1'
        for (i in (fab.xCoord + 1) .. (fab.xCoord + fab.width)) {
            for (j in (fab.yCoord + 1) .. (fab.yCoord + fab.height)) {
                if (board[j][i] == 0) {
                    board[j][i] = fab.id
                } else {
                    board[j][i] = -1
                }
            }
        }
    }

    fun overlapFabric(){
        // Calculating and printing size of overlapping fabric
        var overlap = 0
        for (i in 0 until sizeY) {
            for (j in 0 until sizeX) {
                if (board[i][j] == -1) {
                    overlap += 1
                }
            }
        }
        println(overlap)
    }

    fun perfectFabric(fabricList: MutableList<Fabric>){
        // Part two
        // if '-1' found, go to the next fabric piece
        loop@ for (fab in fabricList) {
            for (i in (fab.xCoord + 1)..(fab.xCoord + fab.width)) {
                for (j in (fab.yCoord + 1)..(fab.yCoord + fab.height)) {
                    if (board[j][i] == -1) {
                        continue@loop
                    }
                }
            }
            println(fab.id)
            break@loop
        }
    }

}

class Fabric(val fabricDescription: String){
    var id: Int = 0
    var xCoord: Int = 0
    var yCoord: Int = 0
    var width: Int = 0
    var height: Int = 0

    init {
        // Parsing input string
        id = fabricDescription.substring(1, fabricDescription.indexOf("@")-1).toInt()
        xCoord = fabricDescription.substring(fabricDescription.indexOf("@")+2, fabricDescription.indexOf(",")).toInt()
        yCoord = fabricDescription.substring(fabricDescription.indexOf(",")+1, fabricDescription.indexOf(":")).toInt()
        width = fabricDescription.substring(fabricDescription.indexOf(":")+2, fabricDescription.indexOf("x")).toInt()
        height = fabricDescription.substring(fabricDescription.indexOf("x")+1).toInt()
    }
}