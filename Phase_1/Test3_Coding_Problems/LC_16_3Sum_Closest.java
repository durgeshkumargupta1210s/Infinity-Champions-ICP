package Test3_Coding_Problems;
import java.util.*;

public class LC_16_3Sum_Closest {

    public static void main(String[] args) {
        // Example input
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        // Call the function and print the closest 3-sum
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * Function to find the sum of three integers in nums such that the sum is closest to the target.
     *
     * @param nums   Input array of integers
     * @param target Target value we want the sum to be close to
     * @return The sum of three integers closest to the target
     */
    public static int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array to apply two-pointer technique easily
        Arrays.sort(nums);

        // Variable to store the closest sum found so far
        // Initialize with a very large value so any first valid sum will replace it
        int finalSum = Integer.MAX_VALUE;

        // Step 2: Iterate through each number as the first element of the triplet
        for (int i = 0; i < nums.length; i++) {

            // Two-pointer initialization
            int left = i + 1;               // start just after i
            int right = nums.length - 1;    // start at the end

            // Step 3: Move the left and right pointers to find the best pair with nums[i]
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];

                // Step 4: Update finalSum if this triplet is closer to target
                if (Math.abs(tempSum - target) < Math.abs(finalSum - target)) {
                    finalSum = tempSum;
                }

                // Step 5: Adjust pointers based on comparison with target
                if (tempSum < target) {
                    // Sum is too small → increase it by moving left pointer to the right
                    left++;
                } else if (tempSum > target) {
                    // Sum is too large → decrease it by moving right pointer to the left
                    right--;
                } else {
                    // If exact match is found, return immediately
                    return target;
                }
            }
        }

        // Step 6: Return the closest sum found after exploring all triplets
        return finalSum;
    }
}
