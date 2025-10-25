package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class LC_64_Minimum_Path_Sum {

    public static void main(String[] args) {
        // Sample input grid
        // Each cell contains a cost, and you must reach the bottom-right corner
        // with the minimum total cost (only moving right or down)
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        // DP array for memoization (stores results of subproblems)
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1); // Initialize with -1 (uncomputed state)
        }

        // Start recursion from top-left corner (0, 0)
        System.out.println(minimumPathSum(0, 0, grid, dp));
    }

    /**
     * Recursive function to compute the minimum path sum
     * from the current cell (cr, cc) to the bottom-right corner.
     */
    private static int minimumPathSum(int cr, int cc, int[][] grid, int[][] dp) {

        // Base Case 1: Out of bounds → return large value (so it’s never chosen)
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        // Base Case 2: Destination cell reached → return its value
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }

        // If already computed, return stored result (memoization)
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        // Recursive calls:
        // Move right → (cr, cc + 1)
        int right = minimumPathSum(cr, cc + 1, grid, dp);

        // Move down → (cr + 1, cc)
        int down = minimumPathSum(cr + 1, cc, grid, dp);

        // Store and return the minimum cost path from current cell
        // Add current cell’s value to the minimum of right/down paths
        return dp[cr][cc] = grid[cr][cc] + Math.min(right, down);
    }
}
