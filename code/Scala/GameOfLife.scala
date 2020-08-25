import scala.util.control.Breaks._

object GameOfLife {
  
  def printGrid(grid: Array[Array[Int]], row: Int, col: Int): Unit = {
    var i,j=0

    for(i<-0 to row-1)
    {
      for(j<-0 to col-1)
      {
        if(grid(i)(j)==1)
          print("o")
        else
          print(".")
      }
      println()
    }
  }

  def checkBounds(i: Int, j: Int, r: Int, c: Int): Boolean = {
    if(i>r || j>c || i<0 || j<0)
    {
      return false
    }
    return true
  }

  def live(grid: Array[Array[Int]]): Unit = {
    val (row, col)=(grid.size, grid(0).size)
    val dir=Array((-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1))

    var live,i,j=0
    for(i<-0 until row)
    {
      for(j<-0 until col)
      {
        live=0
        for(k<-0 until dir.size)
          if(checkBounds(i+dir(k)._1,j+dir(k)._2,row,col) && (grid(i+dir(k)._1)(j+dir(k)._2)).abs==1)
            live+=1

        if(grid(i)(j) == 1 && (live<2 || live>3)) // alive
          grid(i)(j)=(-1)
        else if(grid(i)(j)==0 && live==3) //dead
          grid(i)(j)=2
      }
    }

    for(i<-0 until row)
    {
      for(j<-0 until col)
      {
        if(grid(i)(j)>0)
          grid(i)(j)=1
        else
          grid(i)(j)=0
      }
    }
  }

  def life(generations: Int, grid: Array[Array[Int]]): Array[Array[Int]] = {
    val (row, col)=(grid.size, grid(0).size)

    println(s"\nGeneration ${generations}")
    printGrid(grid,row,col)
    
    for(t=generations-1 until 0 by -1)
    {
      live(grid)
      println(s"\nGeneration ${t}")
      printGrid(grid,row,col)
    }

    return grid
  }
  
  // DO NOT change this function
  def getDefaultGrid(testCaseNo: Int): Array[Array[Int]] = {
    var grid=Array.ofDim[Int](3,3)

    if(testCaseNo == 1)
    {
      grid=Array(Array(1,0,1), 
                 Array(0,1,0),
                 Array(1,0,0))
    }

    return grid
  }

  // DO NOT change this function
  def checkGrid(testCaseNo: Int, inputGrid: Array[Array[Int]]): Boolean = {
    var correctGrid=Array.ofDim[Int](3,3)
    var result=true

    val (row, col)=(inputGrid.size, inputGrid(0).size)

    if(testCaseNo == 1)
    {
      correctGrid=Array(Array(0,1,0), 
                        Array(1,1,0),
                        Array(0,0,0))

      var i,j=0
      for(i<-0 until row)
      {
        for(j<-0 until col)
        {
          if(inputGrid(i)(j)!=correctGrid(i)(j)) {
            result=false
            break
          }
        }
      }
    }

    return result
  }

  // main function
  def main(args: Array[String]): Unit = {
    println(" --- Game of Life --- ")
    
    val generations=2
    var grid=getDefaultGrid(1)

    var successTests=0
    var totalTests=1

    life(generations,grid)

    if(checkGrid(1,grid))
    {
      successTests+=1
      println("This is correct :)")
    }
    else
      println("This is NOT correct :(")

    println("\n\nResult:\n---------------------")
    println("Compilation Test: Passed!")
    println(s"Execution Test: ${successTests}/${totalTests} passed!")
  }

  // // DO NOT uncomment this function
  // def main(args: Array[String]): Unit = {
  //   println(" --- Game of Life --- ")
    
  //   val (row,col)=(7,3)
  //   val generations=8
  //   val value=0.7019
    
  //   var grid=Array.fill(row,col){ if (scala.util.Random.nextFloat()<value) 1 else 0}

  //   life(generations,grid)
  // }

}
