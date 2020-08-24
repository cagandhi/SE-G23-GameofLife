
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

function get_initial_grid()
    grid = [0 0 0 0 0; 0 1 0 1 0; 0 0 1 0 0; 0 1 0 0 0; 0 0 0 0 0]
    return grid
end

function validate_output(grid)
    expected_result = [0 0 0 0 0; 0 0 1 0 0; 0 1 1 0 0; 0 0 0 0 0; 0 0 0 0 0]
    if grid == expected_result
        println("successfully removed logical bug")
        println("Test Passed")
    else
        println("Test Failed")
        println("There is a logical bug in code")
    end
end

function game_of_life(grid, row, col)
    new_grid = zeros(Int32, row+2, col+2)
    for i in 2:row+1
        for j in 2:col+1
            neighbor = grid[i,j-1] + grid[i,j+1] + grid[i+1,j] + grid[i-1,j] + grid[i-1,j-1] + grid[i-1,j+1]+grid[i+1,j-1] + grid[i+1,j+1] + grid[i,j]
            new_grid[i,j] = grid[i,j]
            if grid[i,j] == 0
                new_grid[i,j] = neighbor == 3?1:0
            else
                new_grid[i,j] = neighbor==2 || neighbor == 3 ? 1:0
            end
        end
    end
    return new_grid
end

function execute()
    grid = get_initial_grid()
    println("Initial grid")
    print_grid(grid, 3, 3)
    generation = 2
    for gen in 1:generation-1
        grid = game_of_life(grid, 3, 3)
        println("Generation : ", string(gen))
        print_grid(grid, 3, 3)
    end
    println("successfully removed compilation error")
    validate_output(grid)
end

execute()