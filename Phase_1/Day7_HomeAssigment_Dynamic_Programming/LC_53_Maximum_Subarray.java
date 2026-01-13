package Day7_HomeAssigment_Dynamic_Programming;

public class LC_53_Maximum_Subarray {

	public static void main(String[] args) {
		// Input array of integers (can contain negative and positive numbers)
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		// Calling and printing results from three different approaches
		System.out.println("Memoization approach: " + maxSubArrayMemo(nums));
		System.out.println("Tabulation approach: " + maxSubArrayDP(nums));
		System.out.println("Kadane’s (Optimized) approach: " + maxSubArrayKadane(nums));
	}
	
	// ---------------- MEMOIZATION (Top-Down DP) ----------------
	public static int maxSubArrayMemo(int[] nums) {
	    // dp[i] will store the maximum subarray sum ending at index i
	    Integer[] dp = new Integer[nums.length];
	    
	    int maxSum = nums[0]; // Initialize maxSum with the first element
	    
	    // Iterate through each element and calculate maximum subarray sum ending at i
	    for (int i = 0; i < nums.length; i++) {
	        maxSum = Math.max(maxSum, helper(i, nums, dp));
	    }
	    
	    return maxSum; // Return the maximum among all subarray sums
	}
	
	// Helper function for memoization approach
	private static int helper(int i, int[] nums, Integer[] dp) {
	    // Base case: when we reach the first element
	    if (i == 0) return nums[0];
	    
	    // If result already calculated, return from dp array (memoization)
	    if (dp[i] != null) return dp[i];
	    
	    // Choice:
	    // Either start a new subarray at current index nums[i],
	    // or extend the previous subarray by adding nums[i] to dp[i - 1]
	    dp[i] = Math.max(nums[i], nums[i] + helper(i - 1, nums, dp));
	    
	    return dp[i];
	}
	
	
	// ---------------- TABULATION (Bottom-Up DP) ----------------
	public static int maxSubArrayDP(int[] nums) {
	    int n = nums.length;
	    int[] dp = new int[n]; // dp[i] = maximum subarray sum ending at index i
	    
	    dp[0] = nums[0]; // Base case
	    int maxSum = dp[0];
	    
	    // Build dp table iteratively
	    for (int i = 1; i < n; i++) {
	        // Either start new subarray or extend previous subarray
	        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
	        
	        // Keep track of global maximum
	        maxSum = Math.max(maxSum, dp[i]);
	    }
	    
	    return maxSum;
	}
	
	
	// ---------------- KADANE’S ALGORITHM (Most Optimized) ----------------
	public static int maxSubArrayKadane(int[] nums) {
	    // Kadane's uses only two variables, O(1) space
	    int currSum = nums[0]; // Current subarray sum
	    int maxSum = nums[0];  // Global maximum
	    
	    // Traverse array from 1st index onward
	    for (int i = 1; i < nums.length; i++) {
	        // Either take current element alone or add it to existing subarray
	        currSum = Math.max(nums[i], currSum + nums[i]);
	        
	        // Update global maximum
	        maxSum = Math.max(maxSum, currSum);
	    }
	    
	    return maxSum; // Final result
	}
}
