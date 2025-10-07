package Test3_Coding_Problems;

import java.util.*;

public class LC_1877_Minimize_Maximum_Pair_Sum_in_Array {

    public static void main(String[] args) {
        // Example input array
        int[] nums = {3, 5, 4, 2, 4, 6};

        // Call the function to get the minimum possible maximum pair sum
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(nums); // After sorting: [2, 3, 4, 4, 5, 6]

        // Initialize two pointers
        int left = 0; // Start pointer (smallest element)
        int right = nums.length - 1; // End pointer (largest element)
        
        // Variable to store the maximum sum among all pairs
        int ans = 0;

        // Step 2: Pair the smallest with the largest element, then move inward
        while (left < right) {
            // Calculate sum of the current pair
            int pairSum = nums[left] + nums[right];

            // Update ans if this pair sum is larger than current ans
            ans = Math.max(ans, pairSum);

            // Move pointers inward to form the next pair
            left++;
            right--;
        }

        // Step 3: Return the minimum possible maximum pair sum
        return ans;
    }
}
