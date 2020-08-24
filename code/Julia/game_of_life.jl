
function print_grid(grid,row,col)
    for i in 2:row+1
        for j in 2:col+1
            if grid[i,j] == 1
                print(" # ")
            else
                print(" - ")
            end
        end
        print("\n")
    end
end

function game_of_life(row,col, iteration)
    grid = zeros(Int32, row+2, col+2)
    grid[2:row+1,2:col+1] = map(x -> rand()>.6 ? 1 : 0, grid[2:row+1,2:col+1])
    println("Initial State")
    print_grid(grid,row,col)
    for t in 1:iteration
        new_grid = zeros(Int32, row+2, col+2)
        for i in 2:row+1
            for j in 2:col+1
                neighbor = grid[i,j-1] + grid[i,j+1] + grid[i+1,j] + grid[i-1,j] + grid[i-1,j-1] + grid[i-1,j+1]+grid[i+1,j-1] + grid[i+1,j+1]
                new_grid[i,j] = grid[i,j]
                if grid[i,j] == 0
                    new_grid[i,j] = neighbor == 3?1:0
                else
                    new_grid[i,j] = neighbor==2 || neighbor== 3 ? 1:0
                end
            end
            print("\n")
        end
        grid = new_grid
        println("")
        println("Iteration : ", string(t))
        print_grid(new_grid,row,col)
    end
end

game_of_life(10,5,3)