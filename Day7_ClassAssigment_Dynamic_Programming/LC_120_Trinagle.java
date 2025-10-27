package Day7_ClassAssigment_Dynamic_Programming;
import java.util.*;

public class LC_120_Trinagle {

    public static void main(String[] args) {
        // Create the triangle input
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        // Print results of all approaches
        System.out.println("Top-Down (Memoization): " + minimumTotal(triangle));
        System.out.println("Bottom-Up (Tabulation): " + minimumTotalTab(triangle));
        System.out.println("Space Optimized: " + minimumTotalSpaceOptimized(triangle));
    }

    /**
     * ✅ Approach 1: Top-Down DP (Recursion + Memoization)
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) for dp + O(n) recursion stack
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize dp with a sentinel value (Integer.MAX_VALUE)
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start recursion from top (0,0)
        return minimumPathSum(0, 0, triangle, dp);
    }

    // Recursive function to compute min path sum from (cr, cc) to bottom
    private static int minimumPathSum(int cr, int cc, List<List<Integer>> triangle, int[][] dp) {
        // Base case: if we are at the last row, just return the value at that cell
        if (cr == triangle.size() - 1) {
            return triangle.get(cr).get(cc);
        }

        // If already computed, return the stored result
        if (dp[cr][cc] != Integer.MAX_VALUE) {
            return dp[cr][cc];
        }

        // Recursive calls for downward and diagonal movements
        int down = triangle.get(cr).get(cc) + minimumPathSum(cr + 1, cc, triangle, dp);
        int diagonal = triangle.get(cr).get(cc) + minimumPathSum(cr + 1, cc + 1, triangle, dp);

        // Store the minimum result in dp array
        dp[cr][cc] = Math.min(down, diagonal);

        return dp[cr][cc];
    }

    /**
     * ✅ Approach 2: Bottom-Up DP (Tabulation)
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static int minimumTotalTab(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the last row of dp as the last row of triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Build the dp table from second last row to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The top cell will have the final answer
        return dp[0][0];
    }

    /**
     * ✅ Approach 3: Space Optimized DP
     * Only two rows are needed at a time, so we reduce space to O(n)
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static int minimumTotalSpaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // 'front' represents the row below current row in DP
        int[] front = new int[n];

        // Initialize with last row of triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        // Build upwards
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            front = curr; // Move current row up
        }

        // The top value now contains the result
        return front[0];
    }
}
