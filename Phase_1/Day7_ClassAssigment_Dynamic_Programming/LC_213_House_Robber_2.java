package Day7_ClassAssigment_Dynamic_Programming;

public class LC_213_House_Robber_2 {

	public static void main(String[] args) {
		// Example input
		int[] nums = {1, 2, 3, 1};

		// Calling rob() function and printing the maximum loot
		System.out.println(rob(nums));
	}

	// Function to find the maximum money that can be robbed from circular houses
	public static int rob(int[] nums) {
		int n = nums.length;

		// Edge case: if there is only one house, directly return its value
		if (n == 1) return nums[0];

		// Two temporary arrays to handle the circular condition
		// temp1 → excludes the last house
		// temp2 → excludes the first house
		int[] temp1 = new int[n - 1];
		int[] temp2 = new int[n - 1];

		// Fill temp1 with elements from index 0 to n-2
		for (int i = 0; i < n - 1; i++) {
			temp1[i] = nums[i];
		}

		// Fill temp2 with elements from index 1 to n-1
		for (int i = 1; i < n; i++) {
			temp2[i - 1] = nums[i];
		}

		// Since the first and last houses cannot be robbed together,
		// we compute the maximum loot from both cases and take the maximum
		return Math.max(RobberSO(temp1), RobberSO(temp2));
	}

	// Helper function using Space Optimization (O(1) space)
	// Solves the linear House Robber problem (not circular)
	public static int RobberSO(int[] arr) {
		// Base case: only one house
		if (arr.length == 1) return arr[0];

		// prev2 → dp[i-2], loot till house before the previous one
		// prev  → dp[i-1], loot till the previous house
		int prev2 = arr[0];
		int prev = Math.max(arr[0], arr[1]);

		// Traverse the array starting from the 3rd house (index 2)
		for (int i = 2; i < arr.length; i++) {
			// rob → if we rob the current house, add its value with dp[i-2]
			int rob = arr[i] + prev2;

			// dontRob → if we skip the current house, take dp[i-1]
			int dontRob = prev;

			// Take the maximum of robbing or skipping the current house
			int curr = Math.max(rob, dontRob);

			// Update the previous two states for the next iteration
			prev2 = prev;
			prev = curr;
		}

		// prev holds the maximum loot at the end
		return prev;
	}
}
