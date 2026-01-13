package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class LC_198_House_Robber {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        // Approach 1: Top-down recursion (start from index 0)
        // System.out.println(Robber(arr, 0, dp));

        // Approach 2: Top-down recursion (start from last index)
        System.out.println("Top-Down (Memoization): " + Robber2(arr, arr.length - 1, dp));

        // Approach 3: Bottom-up (Tabulation)
        System.out.println("Bottom-Up (Tabulation): " + RobberBU(arr));

        // Approach 4: Space Optimized DP
        System.out.println("Space Optimized: " + RobberSO(arr));
    }

    // -------------------------------------------------------------------------
    // 🧠 APPROACH 1: RECURSION + MEMOIZATION (start from left, index 0)
    // -------------------------------------------------------------------------
    /**
     * Robber - Recursive approach with memoization
     * Starting from the first house and moving forward.
     *
     * @param arr Array of house values
     * @param i Current index
     * @param dp Memoization array to store results
     * @return Maximum amount that can be robbed
     */
    public static int Robber(int[] arr, int i, int[] dp) {
        // Base case: If index goes out of array bounds
        if (i >= arr.length) {
            return 0;
        }

        // Return precomputed result if present
        if (dp[i] != -1) {
            return dp[i];
        }

        // Option 1: Rob current house and skip next one
        int rob = arr[i] + Robber(arr, i + 2, dp);

        // Option 2: Skip current house and move to next
        int dontRob = Robber(arr, i + 1, dp);

        // Take maximum of both choices
        return dp[i] = Math.max(rob, dontRob);
    }

    // -------------------------------------------------------------------------
    // 🧠 APPROACH 2: RECURSION + MEMOIZATION (start from right, index n-1)
    // -------------------------------------------------------------------------
    /**
     * Robber2 - Recursive approach with memoization (right to left)
     * Starts from the last index and moves backward.
     */
    public static int Robber2(int[] arr, int i, int[] dp) {
        // Base case: If index goes below 0
        if (i < 0) {
            return 0;
        }

        // Return precomputed result if available
        if (dp[i] != -1) {
            return dp[i];
        }

        // Option 1: Rob current house, then move 2 steps back
        int rob = arr[i] + Robber2(arr, i - 2, dp);

        // Option 2: Skip current house, check previous one
        int dontRob = Robber2(arr, i - 1, dp);

        // Take the maximum of both options
        return dp[i] = Math.max(rob, dontRob);
    }

    // -------------------------------------------------------------------------
    // 🧱 APPROACH 3: BOTTOM-UP (TABULATION)
    // -------------------------------------------------------------------------
    /**
     * RobberBU - Bottom-up dynamic programming approach.
     * Iteratively builds the dp array from base cases.
     */
    public static int RobberBU(int[] arr) {
        // Edge case: Only one house
        if (arr.length == 1) {
            return arr[0];
        }

        int[] dp = new int[arr.length];

        // Base cases
        dp[0] = arr[0]; // If only the first house is robbed
        dp[1] = Math.max(arr[0], arr[1]); // Choose the better of first two

        // Build dp table iteratively
        for (int i = 2; i < dp.length; i++) {
            int rob = arr[i] + dp[i - 2]; // Rob this house + best till i-2
            int dontRob = dp[i - 1];      // Skip this house
            dp[i] = Math.max(rob, dontRob);
        }

        // Final answer will be the last element
        return dp[dp.length - 1];
    }

    // -------------------------------------------------------------------------
    // ⚡ APPROACH 4: SPACE OPTIMIZED DYNAMIC PROGRAMMING
    // -------------------------------------------------------------------------
    /**
     * RobberSO - Space optimized version of the DP approach.
     * We only keep track of last two computed values instead of full dp array.
     */
    public static int RobberSO(int[] arr) {
        // Edge case: Only one house
        if (arr.length == 1) {
            return arr[0];
        }

        // prev2 → dp[i-2], prev → dp[i-1]
        int prev2 = arr[0];
        int prev = Math.max(arr[0], arr[1]);

        // Compute iteratively while using only two variables
        for (int i = 2; i < arr.length; i++) {
            int rob = arr[i] + prev2;
            int dontRob = prev;
            int curr = Math.max(rob, dontRob);

            // Slide the window forward
            prev2 = prev;
            prev = curr;
        }

        // 'prev' holds the maximum loot at the end
        return prev;
    }
}
