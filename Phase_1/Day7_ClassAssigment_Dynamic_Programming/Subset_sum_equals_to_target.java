package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class Subset_sum_equals_to_target {

    public static void main(String[] args) {

        int[] arr = {1, 2, 7, 3};
        int target = 6;

        // ---------- TOP-DOWN (Memoization) ----------
        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Top-Down (Memoization): " + checkSumequalsTarget(arr, target, 0, dp));

        // ---------- BOTTOM-UP (Tabulation) ----------
        System.out.println("Bottom-Up (Tabulation): " + subsetSumBottomUp(arr, target));
    }

    // ----------------------------------------------------------
    // 🧠 TOP-DOWN (RECURSION + MEMOIZATION)
    // ----------------------------------------------------------
    private static boolean checkSumequalsTarget(int[] arr, int target, int idx, int[][] dp) {
        // Base case 1: if target becomes 0 → subset found
        if (target == 0) {
            return true;
        }

        // Base case 2: if we reach end of array and target still not 0 → not possible
        if (idx == arr.length) {
            return false;
        }

        // Return previously computed result
        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }

        // Recursive choice: include or exclude current element
        boolean include = false;
        if (arr[idx] <= target) {
            include = checkSumequalsTarget(arr, target - arr[idx], idx + 1, dp);
        }

        boolean exclude = checkSumequalsTarget(arr, target, idx + 1, dp);

        boolean result = include || exclude;

        // Store result in dp table (1 = true, 0 = false)
        dp[idx][target] = result ? 1 : 0;

        return result;
    }

    // ----------------------------------------------------------
    // ⚙️ BOTTOM-UP (TABULATION)
    // ----------------------------------------------------------
    private static boolean subsetSumBottomUp(int[] arr, int target) {
        int n = arr.length;

        // dp[i][t] → true if we can form sum 't' using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case: sum 0 can always be formed (by taking no element)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean exclude = dp[i - 1][t]; // not taking current element
                boolean include = false;

                if (arr[i - 1] <= t) { // can include current element
                    include = dp[i - 1][t - arr[i - 1]];
                }

                dp[i][t] = include || exclude; // store result
            }
        }

        // Final answer is whether we can form 'target' using all elements
        return dp[n][target];
    }
}
