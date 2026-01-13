package Day3_ClassAssigment_2D_Array;

import java.util.*;

public class LC_2570_Merge_Two_2D_Arrays_by_Summing_Values {

    public static void main(String[] args) {
        // Sample input arrays
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};

        // Call the mergeArrays function and store the result
        int[][] merged = mergeArrays(nums1, nums2);

        // Print the merged result for verification
        System.out.println("Merged Array:");
        for (int i = 0; i < merged.length; i++) {
            System.out.println(Arrays.toString(merged[i]));
        }
    }

    /**
     * Merges two 2D arrays by summing values with the same ID
     * and returns the result sorted by the ID.
     *
     * @param nums1 First 2D array [ID, value]
     * @param nums2 Second 2D array [ID, value]
     * @return Merged 2D array sorted by ID
     */
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Use TreeMap to automatically sort keys (IDs) in ascending order
        Map<Integer, Integer> map = new TreeMap<>();

        // Process the first array
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i][0];       // ID
            int value = nums1[i][1];     // Value
            // If key exists, add value; otherwise, initialize with value
            map.put(key, map.getOrDefault(key, 0) + value);
        }

        // Process the second array
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i][0];       // ID
            int value = nums2[i][1];     // Value
            map.put(key, map.getOrDefault(key, 0) + value);
        }

        // Convert the TreeMap into a 2D array
        int[][] result = new int[map.size()][2]; // Each row: [ID, sum]
        int index = 0;

        for (int key : map.keySet()) {
            result[index][0] = key;          // Set ID
            result[index][1] = map.get(key); // Set summed value
            index++;
        }

        return result; // Return the merged and sorted array
    }
}
