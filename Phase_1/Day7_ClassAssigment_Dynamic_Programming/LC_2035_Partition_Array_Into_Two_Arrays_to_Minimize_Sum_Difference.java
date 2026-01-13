package Day7_ClassAssigment_Dynamic_Programming;

public class LC_2035_Partition_Array_Into_Two_Arrays_to_Minimize_Sum_Difference {

    // Global memo table for Top-Down approach
    static int[][] memo;

    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};

        System.out.println("🔹 Bottom-Up DP Result: " + minDifferenceBottomUp(nums));
        System.out.println("🔹 Top-Down DP Result: " + minDifferenceTopDown(nums));
    }

    // ==============================================================
    // 🧮 1️⃣ BOTTOM-UP DYNAMIC PROGRAMMING APPROACH (Tabulation)
    // ==============================================================

    public static int minDifferenceBottomUp(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int n = nums.length;
        boolean[][] dp = new boolean[n][totalSum + 1];

        // Base Case: sum = 0 is always possible (take no elements)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize for first element
        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }

        // Fill DP table (Bottom-Up)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= totalSum; j++) {

                boolean exclude = dp[i - 1][j];
                boolean include = false;

                if (j >= nums[i]) {
                    include = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = include || exclude;
            }
        }

        // Find minimum difference between two subset sums
        int minDifference = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                minDifference = Math.min(minDifference, Math.abs(s2 - s1));
            }
        }

        return minDifference;
    }

    // ==============================================================
    // 🧠 2️⃣ TOP-DOWN DYNAMIC PROGRAMMING APPROACH (Memoization)
    // ==============================================================

    public static int minDifferenceTopDown(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int n = nums.length;

        // Initialize memo table with -1 (uncomputed)
        memo = new int[n][totalSum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                memo[i][j] = -1;
            }
        }

        // Start recursion
        return findMinDiff(nums, n - 1, 0, totalSum);
    }

    // Recursive helper function for Top-Down approach
    private static int findMinDiff(int[] nums, int i, int currSum, int totalSum) {

        // Base case: all elements processed
        if (i < 0) {
            int s2 = totalSum - currSum;
            return Math.abs(s2 - currSum);
        }

        // If already computed, return stored value
        if (memo[i][currSum] != -1) {
            return memo[i][currSum];
        }

        // Choice 1️⃣: Include nums[i] in current subset
        int include = findMinDiff(nums, i - 1, currSum + nums[i], totalSum);

        // Choice 2️⃣: Exclude nums[i] from current subset
        int exclude = findMinDiff(nums, i - 1, currSum, totalSum);

        // Store and return the minimum difference
        return memo[i][currSum] = Math.min(include, exclude);
    }
}
