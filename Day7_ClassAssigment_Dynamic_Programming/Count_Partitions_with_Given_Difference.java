package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class Count_Partitions_with_Given_Difference {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        System.out.println("🔹 Top-Down (Memoization): " + countPartitionsTopDown(arr, diff));
        System.out.println("🔹 Bottom-Up (Tabulation): " + countPartitionsBottomUp(arr, diff));
    }

    // ==============================================================
    // 🧠 1️⃣ TOP-DOWN APPROACH (Recursion + Memoization)
    // ==============================================================

    private static int countPartitionsTopDown(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // If (totalSum - diff) is negative or odd → not possible
        if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) {
            return 0;
        }

        int target = (totalSum - diff) / 2;
        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countSubsetSum(arr, target, 0, dp);
    }

    private static int countSubsetSum(int[] arr, int target, int idx, int[][] dp) {

        // Base Case 1: target achieved
        if (target == 0) return 1;

        // Base Case 2: reached end without meeting target
        if (idx == arr.length) return 0;

        if (dp[idx][target] != -1) return dp[idx][target];

        // Include current element (if possible)
        int include = 0;
        if (arr[idx] <= target) {
            include = countSubsetSum(arr, target - arr[idx], idx + 1, dp);
        }

        // Exclude current element
        int exclude = countSubsetSum(arr, target, idx + 1, dp);

        return dp[idx][target] = include + exclude;
    }

    // ==============================================================
    // 🧮 2️⃣ BOTTOM-UP APPROACH (Tabulation)
    // ==============================================================

    private static int countPartitionsBottomUp(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Edge Case: if invalid (odd or negative)
        if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) {
            return 0;
        }

        int target = (totalSum - diff) / 2;
        int n = arr.length;

        int[][] dp = new int[n + 1][target + 1];

        // Base Case: Only one way to get sum = 0 (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element if it fits
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
