package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class Frog_jump_with_k_distance {

    public static void main(String[] args) {
        // Heights of stones (index represents stone position)
        int[] heights = {10, 5, 20, 0, 15};

        // Maximum distance (in terms of stones) the frog can jump
        int k = 2;

        // dp[i] will store the minimum energy required to reach stone i
        int dp[] = new int[heights.length];
        Arrays.fill(dp, -1);  // Initialize with -1 (means not yet computed)

        // We want the minimum energy to reach the last stone (index = n - 1)
        System.out.println(calculateEnergy(heights, k, dp, heights.length - 1));
    }

    /**
     * Function to calculate the minimum energy required to reach stone 'i'
     *
     * @param heights Array containing heights of each stone
     * @param k Maximum number of steps the frog can jump
     * @param dp Memoization array (stores results of subproblems)
     * @param i Current stone index
     * @return Minimum energy required to reach stone i
     */
    private static int calculateEnergy(int[] heights, int k, int[] dp, int i) {
        // Base Case:
        // If the frog is already at the first stone, no energy is required
        if (i == 0) return 0;

        // If result is already computed for index i, return it
        if (dp[i] != -1) return dp[i];

        int minStep = Integer.MAX_VALUE;  // Initialize minimum energy as infinite

        // Try all possible jumps from 1 to k distance backward
        // Example: If k = 2 and i = 4, frog can come from i-1 = 3 or i-2 = 2
        for (int j = 1; j <= k; j++) {

            // Ensure the previous index (i-j) is valid (non-negative)
            if (i - j >= 0) {

                // Energy required for this jump:
                // (energy to reach previous stone) + (difference in heights)
                int jump = calculateEnergy(heights, k, dp, i - j)
                         + Math.abs(heights[i] - heights[i - j]);

                // Take the minimum among all possible jumps
                minStep = Math.min(minStep, jump);
            }
        }

        // Store the computed result in dp array before returning (memoization)
        return dp[i] = minStep;
    }
}
