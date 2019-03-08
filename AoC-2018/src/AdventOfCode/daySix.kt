package AdventOfCode2018

import java.io.File
import kotlin.math.abs


fun main(args: Array<String>) {
    val file = File("daySix.txt")
    val values: List<String> = file.readLines()

    var table = Table()
    for ((i, value) in values.withIndex()) {
        table.putCoordinate(Point(value.substring(0, value.indexOf(",")).toInt(), value.substring(value.indexOf(",")+2).toInt(), i))

    }
    table.areaCalculate()
    table.infiniteArea()
    table.maxArea()
    table.writingAreaPartTwo()
    table.countRegionPartTwo()

}

class Table() {

    var table = Array(500) { Array(500) {0} }
    var points = mutableListOf<Point>()
    var nearest = 0
    var infiniteID = mutableSetOf<Int>()
    var pointsTemp = mutableListOf<Point>()

    fun putCoordinate(newPoint: Point) {
        table[newPoint.y][newPoint.x] = newPoint.id
        for (i in 0 until 500) {
            for (j in 0 until 500) {
                if (points.isEmpty()) {
                    table[i][j] = newPoint.id
                }else {
                    nearest = isNearest(newPoint, j, i)
                    if (nearest == 3){
                        table[i][j] = newPoint.id
                    }else if (nearest == 2){
                        table[i][j] = -1
                    }
                }
            }
        }
        points.add(newPoint)
    }

    fun areaCalculate() {
        for (point in points) {
            for (i in 0 until 500) {
                for (j in 0 until 500) {
                    if (table[i][j] == point.id){
                        point.area += 1
                    }
                }
            }
        }
    }

    fun infiniteArea() {
        for (i in 0 until 500) {
            for (j in 0 until 500) {
                if (i == 0 || j == 0 || i == 499 || j == 499) {
                    infiniteID.add(table[i][j])
                }
            }
        }
        for (point in points) {
            if (!infiniteID.contains(point.id)) {
                pointsTemp.add(point)
            }
        }
    }

    fun maxArea(){
        var maxArea = pointsTemp.maxBy { it -> it.area }
        if (maxArea != null) {
            println(maxArea.area)
        }

    }

    fun isNearest(mainPt: Point, x: Int, y: Int): Int {
        for (point in points) {
            if (abs(point.x - x) + abs(point.y - y) < abs(mainPt.x - x) + abs(mainPt.y - y)) {
                //Nasa tocka nije najbliza, nemoj zapisivat nas ID na to mjesto OSTAVITI KAKO JE
                return 1
            }
        }
        for (point in points) {
            if (abs(point.x - x) + abs(point.y - y) == abs(mainPt.x - x) + abs(mainPt.y - y)) {
                //Nasa tocka nije najbliza, STAVITI -1
                return 2
            }
        }
        // NAJBLIZA JE
        return 3
    }

    fun writingAreaPartTwo() {
        for (i in 0 until 500) {
            for (j in 0 until 500) {
                if (checkDistance(j, i)) {
                    table[i][j] = -5
                }
            }
        }
    }

    fun checkDistance(x: Int, y: Int): Boolean{
        var sum = 0
        for (point in points) {
            sum += calculateManhattanDistance(x, y, point.x, point.y)
        }
        if (sum < 10000) {
            return true
        }
        return false
    }

    fun calculateManhattanDistance(x: Int, y: Int, xRef: Int, yRef: Int): Int {
        return (abs(x-xRef) + abs(y-yRef))
    }

    fun countRegionPartTwo() {
        var count = 0
        for (i in 0 until 500) {
            for (j in 0 until 500) {
                if (table[i][j] == -5) {
                    count += 1
                }
            }
        }
        println(count)
    }
}

class Point(val x: Int, val y: Int, val id: Int) {

    var area = 0

}