package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class Frog_Jump_problem {

	public static void main(String[] args) {
		
		// Heights of stones where frog is standing
		int []heights = {7, 5, 1, 2, 6};

		// DP array for memoization (store min energy from each index)
		int []dp = new int[heights.length];
		Arrays.fill(dp, -1);  // initialize DP with -1 (meaning not calculated yet)
		
		// Start from index 0 (first stone)
		System.out.println(minimumEnergy(heights, 0, dp));
	}

	// Function to compute minimum energy needed to reach last stone
	private static int minimumEnergy(int[] heights, int i, int []dp) {
		
		// If frog reaches last stone → energy = 0 (base case)
		if(i == heights.length - 1) return 0;
		
		// If index goes beyond limit → invalid path, return large value
		if(i > heights.length - 1) {
			return Integer.MAX_VALUE;
		}
		
		// If already computed, return stored answer (Memoization)
		if(dp[i] != -1) {
			return dp[i];
		}
		
		// Option 1: Jump to next stone (i+1)
		int one = Integer.MAX_VALUE;
		if(i + 1 < heights.length) {
			one = Math.abs(heights[i] - heights[i + 1]) 
			      + minimumEnergy(heights, i + 1, dp);
		}
		
		// Option 2: Jump over one stone (i+2)
		int two = Integer.MAX_VALUE;
		if(i + 2 < heights.length) {
			two = Math.abs(heights[i] - heights[i + 2]) 
			      + minimumEnergy(heights, i + 2, dp);
		}
		
		// Store minimum energy path in dp and return
		return dp[i] = Math.min(one, two);
	}
}
