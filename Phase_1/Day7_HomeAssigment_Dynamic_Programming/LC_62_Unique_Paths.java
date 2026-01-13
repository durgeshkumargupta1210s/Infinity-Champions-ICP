package Day7_HomeAssigment_Dynamic_Programming;

import java.util.*;

public class LC_62_Unique_Paths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        // Expected output: 28
        System.out.println(uniquePaths(m, n));
    }

    /**
     * Main function to calculate the total number of unique paths
     * from top-left corner (0, 0) to bottom-right corner (m-1, n-1)
     * using memoization (top-down DP).
     *
     * @param m  number of rows
     * @param n  number of columns
     * @return   total unique paths
     */
    public static int uniquePaths(int m, int n) {
        // Create a DP table initialized with -1
        // dp[i][j] will store number of unique paths from (i, j) to destination
        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Start from (0, 0)
        return countPath(0, 0, m, n, dp);
    }

    /**
     * Recursive function to count all unique paths from current cell (cr, cc)
     * to destination cell (m-1, n-1).
     *
     * Moves allowed: only RIGHT or DOWN.
     *
     * @param cr  current row
     * @param cc  current column
     * @param m   total rows
     * @param n   total columns
     * @param dp  memoization table
     * @return    number of paths from (cr, cc) to destination
     */
    public static int countPath(int cr, int cc, int m, int n, int[][] dp) {

        // Out of bounds → no path
        if (cr >= m || cc >= n) {
            return 0;
        }

        // If we already computed this state, return cached result
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        // Base case: reached bottom-right corner → 1 valid path
        if (cr == m - 1 && cc == n - 1) {
            return 1;
        }

        // Move Down and Right recursively
        int down = countPath(cr + 1, cc, m, n, dp);
        int right = countPath(cr, cc + 1, m, n, dp);

        // Store and return total paths from (cr, cc)
        return dp[cr][cc] = down + right;
    }
}
