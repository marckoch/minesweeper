package stage2

import java.util.*
import kotlin.random.Random

const val MINE = 'X'
const val FREE = '.'
const val DIMENSION = 9

class MineSweeper {
    private val minefield = Array(DIMENSION) { Array(DIMENSION) { FREE } }

    fun randomize(count: Int) {
        var left = count
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
}

fun main() {
    val mineSweeper = MineSweeper()

    print("How many mines do you want on the field? ")
    val noOfMines = Scanner(System.`in`).nextInt()

    mineSweeper.randomize(noOfMines)
    mineSweeper.printState()
}