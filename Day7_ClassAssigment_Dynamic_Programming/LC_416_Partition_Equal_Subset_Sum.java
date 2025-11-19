package Day7_ClassAssigment_Dynamic_Programming;
import java.util.*;

public class LC_416_Partition_Equal_Subset_Sum {

	public static void main(String[] args) {
		// Example array
		int []nums = {1,5,11,5};
		
		// Function call to check if equal partition is possible
		System.out.println(canPartition(nums));
	}

	// Function to check if array can be partitioned into two subsets of equal sum
	public static boolean canPartition(int[] nums) {
		int sum = 0;

		// Calculate total sum of elements
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
		}

		// If total sum is odd, equal partition is not possible
		if(sum % 2 != 0){
			return false;
		}

		// DP array to store results for memoization
		// dp[i][j] stores whether we can make sum j using elements from index i to end
		int [][] dp = new int[nums.length][(sum/2) + 1];
		for(int [] arr : dp){
			Arrays.fill(arr, -1); // Initialize with -1 (unvisited)
		}

		// Try to find subset with sum = sum/2
		return canPartitionArray(nums, sum/2, 0, dp);
	}

	// Recursive function with memoization
	public static boolean canPartitionArray(int[] nums, int target, int idx, int [][] dp){
		
		// If target becomes 0, we've found a valid subset
		if(target == 0){
			return true;
		}

		// If no more elements left but target not met, return false
		if(idx == nums.length){
			return false;
		}

		// If already calculated, return stored value
		if(dp[idx][target] != -1){
			return dp[idx][target] == 1;
		}

		boolean include = false;

		// Try including current element if it does not exceed the target
		if(nums[idx] <= target){
			include = canPartitionArray(nums, target - nums[idx], idx + 1, dp);
		}

		// Try excluding current element
		boolean exclude = canPartitionArray(nums, target, idx + 1, dp);

		// If either include or exclude returns true, result is true
		boolean result = include || exclude;

		// Store result in DP table (1 for true, 0 for false)
		dp[idx][target] = result ? 1 : 0;
		return result;
	}
}
