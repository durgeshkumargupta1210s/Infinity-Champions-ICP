package Test3_Coding_Problems;

public class LC_486_Predict_the_Winner {

    public static void main(String[] args) {
        // Example input
        int[] nums = {1, 5, 2};

        // Check if Player 1 can win or tie
        System.out.println(predictTheWinner(nums));
    }

    // Main function to predict if Player 1 can win or at least tie
    public static boolean predictTheWinner(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int total = 0;

        // dp[i][j] will store the maximum score the current player can achieve 
        // from subarray nums[i...j]
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        // Calculate total sum of all elements
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        // p1 = maximum score Player 1 can achieve with optimal strategy
        int p1 = OptimalGameStrategy(nums, left, right, dp);

        // p2 = remaining score = total - p1
        int p2 = total - p1;

        // Player 1 wins or ties if their score is >= Player 2
        return p1 >= p2;
    }

    // Recursive function with memoization to find the maximum score
    // the current player can get from nums[left...right]
    public static int OptimalGameStrategy(int[] nums, int left, int right, int[][] dp) {
        // Base case: If indices cross, no elements are left
        if (left > right) {
            return 0;
        }

        // Return the stored result if this state has been solved before
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        /*
         * If the player chooses the left number:
         * - The opponent will then play optimally and leave the minimum score for the player in the next move.
         * - So, after choosing nums[left], the opponent can choose either left+1 or right.
         * - We take Math.min() because the opponent minimizes our future gain.
         */
        int choose_left = nums[left] + Math.min(
                OptimalGameStrategy(nums, left + 2, right, dp),    // opponent takes left+1
                OptimalGameStrategy(nums, left + 1, right - 1, dp) // opponent takes right
        );

        /*
         * If the player chooses the right number:
         * - Similarly, opponent minimizes the future score.
         */
        int choose_right = nums[right] + Math.min(
                OptimalGameStrategy(nums, left + 1, right - 1, dp), // opponent takes left
                OptimalGameStrategy(nums, left, right - 2, dp)      // opponent takes right-1
        );

        // The player will choose the option that maximizes their score
        dp[left][right] = Math.max(choose_left, choose_right);

        return dp[left][right];
    }
}
