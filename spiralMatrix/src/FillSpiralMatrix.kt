import java.lang.String.format

// Fill matrix in spiral form from 1 to (dimX * dimY)
fun main(args: Array<String>) {
    val dimX = 6
    val dimY = 7
    val matrix = Array(dimX) { Array(dimY) {0} }
    var count = 1



    loop@ for (i in 0 until (dimX / 2) + 1) {

        for (j in i until dimY - i) {
            // Top row
            if (count > dimX * dimY) {
                break@loop
            }
            matrix[i][j] = count
            count += 1
        }

        for (k in i + 1 until dimX - i) {
            // Right column
            if (count > dimX * dimY) {
                break@loop
            }
            matrix[k][dimY - i - 1] = count
            count += 1
        }

        for (l in dimY - i - 2 downTo i) {
            // Bottom row
            if (count > dimX * dimY) {
                break@loop
            }
            matrix[dimX - i - 1][l] = count
            count += 1
        }

        for (p in dimX - i - 2 downTo i + 1) {
            // Left column
            if (count > dimX * dimY) {
                break@loop
            }
            matrix[p][i] = count
            count += 1
        }
    }

// Printing matrix
    for (row in matrix) {
        for (i in row) {
            print(format("%5d", i))
        }
        println("")
    }
}

