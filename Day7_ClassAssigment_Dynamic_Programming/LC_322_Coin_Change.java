package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class LC_322_Coin_Change{

    // ------------------------------------------------------------
    // 1️⃣ TOP-DOWN RECURSION + MEMOIZATION (DFS + DP)
    // ------------------------------------------------------------
    private static int topDownCoinChange(int[] coins, int amount, int idx, int[][] dp) {

        // BASE CASE: only smallest coin left
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];   // exact divisible case
            }
            return 100000000;               // impossible -> return large value
        }

        // MEMOIZATION CHECK
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        // ---------------------------
        // OPTION 1: EXCLUDE CURRENT COIN → move to previous coin
        // ---------------------------
        int exclude = topDownCoinChange(coins, amount, idx - 1, dp);

        // ---------------------------
        // OPTION 2: INCLUDE CURRENT COIN → stay on same coin index
        // ---------------------------
        int include = 100000000;
        if (coins[idx] <= amount) {
            include = 1 + topDownCoinChange(coins, amount - coins[idx], idx, dp);
        }

        // STORE & RETURN RESULT
        return dp[idx][amount] = Math.min(exclude, include);
    }

    // ------------------------------------------------------------
    // 2️⃣ BOTTOM-UP TABULATION DP (2D DP)
    // ------------------------------------------------------------
    private static int bottomUpCoinChange(int[] coins, int amount) {

        int n = coins.length;
        int MAX = 100000000;

        // dp[i][j] = min coins to make amount j using coins[0..i]
        int[][] dp = new int[n][amount + 1];

        // Fill base row (i = 0) using only the smallest coin
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = MAX;
            }
        }

        // Build table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                // Option 1: Exclude current coin
                int exclude = dp[i - 1][j];

                // Option 2: Include current coin
                int include = MAX;
                if (coins[i] <= j) {
                    include = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(exclude, include);
            }
        }

        return dp[n - 1][amount] >= MAX ? -1 : dp[n - 1][amount];
    }

    // ------------------------------------------------------------
    // 3️⃣ SPACE-OPTIMIZED DP (1D ARRAY)
    // ------------------------------------------------------------
    private static int spaceOptimizedCoinChange(int[] coins, int amount) {

        int MAX = 100000000;

        // dp[j] = minimum coins needed for amount j
        int[] dp = new int[amount + 1];

        // Initialize dp array
        Arrays.fill(dp, MAX);
        dp[0] = 0; // base: 0 coins needed to make amount 0

        // Update dp for each coin
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] >= MAX ? -1 : dp[amount];
    }

    // ------------------------------------------------------------
    // MAIN METHOD TO RUN ALL THREE SOLUTIONS
    // ------------------------------------------------------------
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        // -------------------------------
        // 1️⃣ RUN TOP-DOWN MEMOIZATION
        // -------------------------------
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        int ansTopDown = topDownCoinChange(coins, amount, coins.length - 1, dp);
        if (ansTopDown >= 100000000) ansTopDown = -1;

        System.out.println("Top-Down Memoization Result: " + ansTopDown);

        // -------------------------------
        // 2️⃣ RUN BOTTOM-UP TABULATION
        // -------------------------------
        int ansBottomUp = bottomUpCoinChange(coins, amount);
        System.out.println("Bottom-Up 2D DP Result: " + ansBottomUp);

        // -------------------------------
        // 3️⃣ RUN SPACE-OPTIMIZED DP
        // -------------------------------
        int ansOptimized = spaceOptimizedCoinChange(coins, amount);
        System.out.println("Space-Optimized DP Result: " + ansOptimized);
    }
}
