package stage3


import java.util.*
import kotlin.random.Random

const val MINE = 'X'
const val FREE = '.'
const val DIMENSION = 9

class MineSweeper {
    private val minefield = Array(DIMENSION) { Array(DIMENSION) { FREE } }

    fun randomize(count: Int) {
        var left = minOf(count, DIMENSION * DIMENSION)
        while (left > 0) {
            val row = Random.nextInt(DIMENSION)
            val col = Random.nextInt(DIMENSION)
            if (minefield[row][col] == FREE) {
                minefield[row][col] = MINE
                left--
            }
        }
    }

    fun printState() {
        for (row in minefield) {
            for (f in row) {
                print(f)
            }
            println()
        }
    }

    fun addHints() {
        for (row in 0 until DIMENSION) {
            for (col in 0 until DIMENSION) {
                if (minefield[row][col] == MINE) {
                    increaseAllNeighbors(row, col)
                }
            }
        }
    }

    // we know 'row'/'col' indicates a mine, so all its neighbors
    // are increased by 1 (if they are not a mine)
    private fun increaseAllNeighbors(row: Int, col: Int) {
        for (x in (row - 1)..(row + 1)) {
            for (y in (col - 1)..(col + 1)) {
                if (x in 0 until DIMENSION && y in 0 until DIMENSION) {
                    if (minefield[x][y] == MINE) {
                        continue
                    } else if (minefield[x][y] == FREE) {
                        minefield[x][y] = '0'
                    }
                    val count = minefield[x][y].toInt()
                    minefield[x][y] = (count + 1).toChar()
                }
            }
        }
    }
}

fun main() {
    val mineSweeper = MineSweeper()

    print("How many mines do you want on the field? ")
    val noOfMines = Scanner(System.`in`).nextInt()

    mineSweeper.randomize(noOfMines)
    mineSweeper.addHints()
    mineSweeper.printState()
}
