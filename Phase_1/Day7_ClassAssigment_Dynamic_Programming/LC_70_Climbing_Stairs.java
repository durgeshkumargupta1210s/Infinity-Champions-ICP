package Day7_ClassAssigment_Dynamic_Programming;

public class LC_70_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		System.out.println(climbStairs(n));

	}
	public static int climbStairs(int n) {
        // Create a dp array to store the number of ways for each step
        // dp[i] will represent the number of ways to reach step i
        int[] dp = new int[n + 1];

        // Use a helper function with memoization to compute the result
        return calculateStep(n, dp);
    }

    // Recursive function with memoization to calculate ways to climb n steps
    public static int calculateStep(int n, int[] dp) {

        // Base cases:
        // If there are 0 steps, there's 1 way (stay at ground)
        // If there is 1 step, there's also 1 way (take one step)
        if (n == 0 || n == 1) {
            return 1;
        }

        // If the result for current n is already computed, return it
        // This avoids redundant recursive calls and improves efficiency
        if (dp[n] != 0) {
            return dp[n];
        }

        // Recursive relation:
        // Number of ways to reach step n =
        // ways to reach (n - 1) + ways to reach (n - 2)
        // Because from step (n - 1), you can take 1 step
        // And from step (n - 2), you can take 2 steps
        int one_step = calculateStep(n - 1, dp);
        int two_step = calculateStep(n - 2, dp);

        // Store the computed result in dp array (memoization)
        dp[n] = one_step + two_step;

        // Return the total number of ways for n steps
        return dp[n];
    }

}
