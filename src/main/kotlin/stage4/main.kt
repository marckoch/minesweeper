package stage4

import java.util.*
import kotlin.random.Random

const val FREE = '.'
const val MARKER = '*'
const val DIMENSION = 9

val scanner = Scanner(System.`in`)

class Cell {
    var isMine: Boolean = false
    var isMarked: Boolean = false
}

class MineSweeper(private var noOfMines: Int) {
    private val minefield = Array(DIMENSION) { Array(DIMENSION) { Cell() } }

    init {
        fillRandomly()
    }

    private fun fillRandomly() {
        var left = minOf(noOfMines, DIMENSION * DIMENSION)
        while (left > 0) {
            val row = Random.nextInt(DIMENSION)
            val col = Random.nextInt(DIMENSION)
            if (!minefield[row][col].isMine) {
                minefield[row][col].isMine = true
                left--
            }
        }
    }

    fun printState() {
        println(" |123456789|")
        println("-|---------|")
        for (row in 0 until DIMENSION) {
            print("${row + 1}|")
            for (col in 0 until DIMENSION) {
                val cell = minefield[row][col]
                when {
                    cell.isMarked -> print(MARKER)
                    cell.isMine -> print(FREE)
                    else -> {
                        val count = countAdjacentMines(row, col)
                        print(if (count > 0) "$count" else FREE)
                    }
                }
            }
            print("|")
            println()
        }
        println("-|---------|")
    }

    fun countAdjacentMines(row: Int, col: Int): Int {
        if (minefield[row][col].isMine) {
            return 0
        }

        var mineCount = 0
        for (x in (row - 1)..(row + 1)) {
            for (y in (col - 1)..(col + 1)) {
                if (x == 0 && y == 0) {
                    continue
                }
                if (x in 0 until DIMENSION && y in 0 until DIMENSION) {
                    if (minefield[x][y].isMine) {
                        mineCount++
                    }
                }
            }
        }
        return mineCount
    }

    fun toggleMarker(row: Int, col: Int) {
        minefield[row][col].isMarked = !minefield[row][col].isMarked
    }

    fun isGameWon(): Boolean {
        var countCorrectMarkers = 0
        var countWrongMarkers = 0

        for (row in 0 until DIMENSION) {
            for (col in 0 until DIMENSION) {
                val cell = minefield[row][col]

                if (cell.isMarked && cell.isMine) {
                    countCorrectMarkers++
                }
                if (cell.isMarked && !cell.isMine) {
                    countWrongMarkers++
                }
            }
        }
        return countCorrectMarkers == noOfMines && countWrongMarkers == 0
    }
}

fun main() {
    print("How many mines do you want on the field? ")
    val noOfMines = scanner.nextInt()

    val mineSweeper = MineSweeper(noOfMines)
    mineSweeper.printState()

    do {
        print("Set/delete mines marks (x and y coordinates): ")
        val x = scanner.nextInt() - 1 // this is column!
        val y = scanner.nextInt() - 1 // this is row!

        if (mineSweeper.countAdjacentMines(y, x) > 0) {
            println("There is a a number here!")
            continue
        } else {
            mineSweeper.toggleMarker(y, x)
            mineSweeper.printState()
        }
    } while (!mineSweeper.isGameWon())

    println("Congratulations! You found all the mines!")
}