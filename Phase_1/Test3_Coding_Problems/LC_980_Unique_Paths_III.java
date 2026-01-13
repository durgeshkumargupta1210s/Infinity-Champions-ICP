package Test3_Coding_Problems;

public class LC_980_Unique_Paths_III {

    public static void main(String[] args) {
        // Example grid:
        // 1 → starting cell
        // 2 → ending cell
        // 0 → empty cell (must be visited exactly once)
        // -1 → obstacle
        int [][] grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        };

        // Call the function and print total number of unique paths
        System.out.println(uniquePathsIII(grid));
    }

    /**
     * Counts the number of unique paths that start at 1, end at 2,
     * and visit all non-obstacle squares exactly once.
     */
    public static int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;  // starting cell coordinates
        int empty = 0;                   // count of empty cells (0)

        // Step 1: Find the starting cell (1) and count all empty cells (0)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // Step 2: Start DFS from the starting cell
        // `remain = empty + 1` includes empty cells + starting cell itself
        return totalPath(grid, startRow, startCol, empty + 1);
    }

    /**
     * Recursive DFS function that explores all valid paths.
     *
     * @param grid   - the grid
     * @param cr     - current row
     * @param cc     - current column
     * @param remain - number of cells left to visit (including current)
     * @return number of valid unique paths from this cell
     */
    public static int totalPath(int [][] grid, int cr, int cc, int remain) {

        // Step 1: Boundary checks and obstacle check
        if (cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length || grid[cr][cc] == -1) {
            return 0;  // out of grid or hit obstacle / visited cell
        }

        // Step 2: If we reach the end cell (2)
        // Only count this path if all empty cells have been visited (remain == 0)
        if (grid[cr][cc] == 2) {
            return remain == 0 ? 1 : 0;
        }

        // Step 3: Mark the current cell as visited (temporarily)
        int temp = grid[cr][cc];
        grid[cr][cc] = -1;

        // Step 4: Explore all four directions recursively
        int left  = totalPath(grid, cr, cc - 1, remain - 1);
        int right = totalPath(grid, cr, cc + 1, remain - 1);
        int up    = totalPath(grid, cr - 1, cc, remain - 1);
        int down  = totalPath(grid, cr + 1, cc, remain - 1);

        // Step 5: Restore the cell after exploring (backtracking)
        grid[cr][cc] = temp;

        // Step 6: Return total number of valid paths found from all directions
        return left + right + up + down;
    }
}
