package Day4_ClassAssigment;
import java.util.*;

public class LC_922_Subarrays_with_K_Different_Integers {

	public static void main(String[] args) {
		// Example input
		int []nums = {1,2,1,2,3};
		int k = 2;

		/*
		 * Exactly K distinct = AtMost(K) - AtMost(K-1)
		 */
		int result = countSubArrayWithDistinctElement(nums, k) 
		           - countSubArrayWithDistinctElement(nums, k-1);

		System.out.println(result); // Expected: 7
	}

	// Function to count subarrays with AT MOST k distinct elements
	private static int countSubArrayWithDistinctElement(int[] nums, int k) {
		int count = 0; // total subarrays
		int si = 0;    // sliding window start
		HashMap<Integer,Integer> map = new HashMap<>(); // element frequency in window

		for (int ei = 0; ei < nums.length; ei++) {
			// include nums[ei] into the window
			map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

			// shrink window until it has at most k distinct numbers
			while (map.size() > k) {
				map.put(nums[si], map.get(nums[si]) - 1);

				// ✅ FIX: should check nums[si], not nums[ei]
				if (map.get(nums[si]) == 0) {
					map.remove(nums[si]);
				}
				si++; // move start forward
			}

			// all subarrays ending at ei and starting from si..ei are valid
			count += ei - si + 1;
		}
		return count;
	}
}
