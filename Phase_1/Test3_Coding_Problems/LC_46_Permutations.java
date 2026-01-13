package Test3_Coding_Problems;

import java.util.*;

public class LC_46_Permutations {

    // Global list to store all generated permutations
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 2, 3, 4};

        // Temporary list to build current permutation
        List<Integer> list = new ArrayList<>();

        // Boolean array to mark visited elements
        boolean[] backTrack = new boolean[nums.length];

        // Generate all permutations
        GeneratePermutation(nums, list, backTrack);

        // Print all generated permutations
        for (List<Integer> ele : result) {
            System.out.println(ele);
        }
    }

    /**
     * Recursive function to generate all permutations of the array using backtracking.
     *
     * @param nums       input array of integers
     * @param list       current permutation being constructed
     * @param backTrack  boolean array to track which elements have been used
     */
    private static void GeneratePermutation(int[] nums, List<Integer> list, boolean[] backTrack) {
        // ✅ Base Case: When the permutation is complete (same size as nums)
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));  // Add a copy of the current permutation to result
            return;
        }

        // Try placing each unused element at the current position
        for (int i = 0; i < nums.length; i++) {
            // If the current element has not been used in this permutation
            if (!backTrack[i]) {
                backTrack[i] = true;          // Mark it as used
                list.add(nums[i]);            // Choose the element

                // Recurse to build the rest of the permutation
                GeneratePermutation(nums, list, backTrack);

                // Backtrack: undo the choice to explore other options
                list.remove(list.size() - 1);
                backTrack[i] = false;
            }
        }
    }
}

