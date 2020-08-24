import kotlin.random.Random

fun main() {
    println("Game Of Life!!")

    var generations = 2
    var correctExecution = 0

    var board = getDefault(1)
    println("\nGeneration: $generations")
    showBoard(board)

    //we want this loop to run from 'generations-1' to '1'
    for (i in generations-1...1){
        println("\n\nGeneration: $i")
        gameOfLife(board)
        showBoard(board)

        if(check(1,board)){
            correctExecution+=1
            println("This is correct :)")
        }
        else{
            println("This is NOT correct :(")
        }
        
    }

    println("\n\nResult:\n---------------------")
    println("Compilation Test: Passed!")
    println("Execution Test: $correctExecution/1 passed!")

}

fun showBoard(board: Array<IntArray>): Unit {
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
                        liveNeighbours = liveNeighbours + board[nextRow][nextCol]
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

//Don't change this function
fun getDefault(testCaseNumber: Int): Array<IntArray>{
    var board = Array(0) {IntArray(0)}
    if(testCaseNumber == 1){
        board = arrayOf(intArrayOf(1,0,1),
                        intArrayOf(0,1,0),
                        intArrayOf(1,0,0)) 
    }
    return board
}

//Don't change this function
fun check(testCaseNumber: Int, board: Array<IntArray>): Boolean{
    var expectedBoard = Array(0) {IntArray(0)}
    var result = false
    if(testCaseNumber == 1){
        expectedBoard = arrayOf(intArrayOf(0,1,0),
                                intArrayOf(1,1,0),
                                intArrayOf(0,0,0))

        if(board.contentDeepEquals(expectedBoard)){
            result = true
        }
    }
    return result
}

/*
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
*/