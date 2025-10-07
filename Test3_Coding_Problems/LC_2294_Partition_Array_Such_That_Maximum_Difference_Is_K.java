package Test3_Coding_Problems;
import java.util.*;

public class LC_2294_Partition_Array_Such_That_Maximum_Difference_Is_K {

    public static void main(String[] args) {
        // Example input
        int[] nums = {3, 6, 1, 2, 5};
        int k = 0;

        // Call the function and print the minimum number of partitions
        System.out.println(partitionArray(nums, k));
    }

    /**
     * Function to partition the array into the minimum number of groups
     * such that the difference between the maximum and minimum in each group is <= k.
     *
     * Approach:
     * 1. Sort the array.
     * 2. Start from the first element and track the minimum of the current group.
     * 3. Traverse the array:
     *    - If the difference between current element and minimum > k → start a new group.
     *    - Otherwise, keep adding elements to the current group.
     * 4. Return the total number of groups formed.
     *
     * Time Complexity: O(n log n)   (because of sorting)
     * Space Complexity: O(1)       (in-place)
     */
    public static int partitionArray(int[] nums, int k) {
        // Step 1: Sort the array to group elements with close values together
        Arrays.sort(nums);

        // At least one group will be formed
        int count = 1;

        // 'minimum' tracks the minimum element in the current group
        int minimum = nums[0];

        // Step 2: Traverse the sorted array
        for (int i = 1; i < nums.length; i++) {
            // If current element exceeds the allowed difference (k) from minimum,
            // start a new group
            if (nums[i] - minimum > k) {
                count++;             // New group formed
                minimum = nums[i];   // Reset minimum for new group
            }
        }

        // Return total number of groups
        return count;
    }
}
