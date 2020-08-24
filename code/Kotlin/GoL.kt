import kotlin.random.Random

fun main() {
    println("Game Of Life!!")

    var board = initLife(4,5,(0.619).toFloat())
    println("\nGeneration: 0")
    showLife(board)

    var generations = 5
    for (i in 1..generations){
        println("\n\nGeneration: $i")
        gameOfLife(board)
        showLife(board)
    }

}

fun initLife(rows: Int, cols: Int, seed: Float): Array<IntArray>{
    var board = Array(rows) {IntArray(cols)}
    for (i in 0..rows-1){
        for (j in 0..cols-1){
            if(Random.nextFloat() < seed)
            {
                board[i][j]=1
            }
        }
    }
    return board
}

fun showLife(board: Array<IntArray>): Unit {
    val rows = board.count()
    val cols = board[0].count()
    for (i in 0..rows-1){
        for (j in 0..cols-1){
            if (board[i][j] == 0){
                print(".")
            }
            else{
                print("o")
            }
        }
        println()
    }
}

fun checkBounds(rows: Int , cols: Int, nextRow: Int, nextCol: Int): Boolean {
    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols){
        return true
    }
    return false
}

fun gameOfLife(board: Array<IntArray>): Unit {
    val rows = board.count()
    val cols = board[0].count()
    var nextRow = 0
    var nextCol = 0
    var liveNeighbours = 0
    var directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0), Pair(1, 1), Pair(-1, -1), Pair(1, -1), Pair(-1, 1) )
    // alive to dead --> -1
    // dead to alive --> -2
    for (i in 0..rows-1){
        for (j in 0..cols-1){
            liveNeighbours = 0
            for (d in 0..directions.count()-1){
                nextRow = i + directions[d].first
                nextCol = j + directions[d].second
                if(checkBounds(rows, cols, nextRow, nextCol)){
                    if(board[nextRow][nextCol]==1 || board[nextRow][nextCol]==-1){
                        liveNeighbours = liveNeighbours + 1
                    }
                }   
            }
            if (board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3)){
                board[i][j] = -1
            }
            else if (board[i][j] == 0 && (liveNeighbours == 3)){
                board[i][j] = -2
            }
        }
    }
    for (i in 0..rows-1){
        for (j in 0..cols-1){
            if (board[i][j] == -1){
                board[i][j] = 0
            }
            else if (board[i][j] == -2){
                board[i][j] = 1
            }
        }
    }
}
