package Day7_ClassAssigment_Dynamic_Programming;
import java.util.*;

public class LC_931_Minimum_Falling_Path_Sum {

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println("Memoization (Top-Down): " + minFallingPathSum_Memo(matrix));
        System.out.println("Tabulation (Bottom-Up): " + minFallingPathSum_Tab(matrix));
        System.out.println("Space Optimized: " + minFallingPathSum_SO(matrix));
    }

    // ---------------------------------------------------------------
    // 🧠 1️⃣ TOP-DOWN (Memoization) Approach
    // ---------------------------------------------------------------
    public static int minFallingPathSum_Memo(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;

        // Create dp table initialized with sentinel values
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Try starting from each element in the first row
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, calculatePath(0, i, matrix, dp));
        }

        return ans;
    }

    // Recursive function to compute the minimum path using memoization
    public static int calculatePath(int cr, int cc, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        // Out of bounds (column-wise)
        if (cc < 0 || cc >= n) {
            return Integer.MAX_VALUE;
        }

        // Base case: last row
        if (cr == n - 1) {
            return matrix[cr][cc];
        }

        // Return cached result
        if (dp[cr][cc] != Integer.MAX_VALUE) {
            return dp[cr][cc];
        }

        // Recursive calls for down, left diagonal, and right diagonal
        int down = calculatePath(cr + 1, cc, matrix, dp);
        int leftDiagonal = calculatePath(cr + 1, cc - 1, matrix, dp);
        int rightDiagonal = calculatePath(cr + 1, cc + 1, matrix, dp);

        // Memoize and return the minimum path sum
        dp[cr][cc] = matrix[cr][cc] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));
        return dp[cr][cc];
    }

    // ---------------------------------------------------------------
    // 🧾 2️⃣ BOTTOM-UP (Tabulation) Approach
    // ---------------------------------------------------------------
    public static int minFallingPathSum_Tab(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: copy the last row (as it's the starting point for bottom-up)
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Build the dp table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[i + 1][j];
                int leftDiagonal = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Minimum path sum starting from any cell in the first row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }

    // ---------------------------------------------------------------
    // ⚙️ 3️⃣ SPACE OPTIMIZED (O(n)) Approach
    // ---------------------------------------------------------------
    public static int minFallingPathSum_SO(int[][] matrix) {
        int n = matrix.length;

        // 'front' represents the row below the current one
        int[] front = new int[n];
        int[] curr = new int[n];

        // Initialize front with the last row
        for (int j = 0; j < n; j++) {
            front[j] = matrix[n - 1][j];
        }

        // Process rows from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = front[j];
                int leftDiagonal = (j > 0) ? front[j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n - 1) ? front[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
            // Move current row to front for next iteration
            front = curr.clone();
        }

        // Final answer = minimum value from top row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, front[j]);
        }

        return ans;
    }
}
