package Day10_HomeAssigment_Stack_and_Queue;

import java.util.*;

public class LC_496_Next_Greater_Element_I {

    /**
     * For each element in nums1, find the next greater element in nums2.
     *
     * Logic:
     * - Use a stack to keep track of elements whose next greater hasn't been found yet
     * - Use a map to store the next greater element for each number in nums2
     * - For each num in nums2:
     *     - Pop elements from stack that are smaller than current num and map them to current num
     *     - Push current num to stack
     * - Remaining elements in stack have no next greater, map them to -1
     * - Finally, build result for nums1 using the map
     *
     * @param nums1 - subset array
     * @param nums2 - larger array
     * @return array of next greater elements
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // Map from element to its next greater
        Stack<Integer> stack = new Stack<>();        // Stack to maintain decreasing sequence

        // Build next greater map for nums2
        for (int num : nums2) {
            // While stack top is smaller than current num, current num is its next greater
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            // Push current number to stack
            stack.push(num);
        }

        // Remaining elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2); // Output: [-1, 3, -1]
        System.out.println(Arrays.toString(res));

        int[] nums3 = {2,4};
        int[] nums4 = {1,2,3,4};
        int[] res2 = nextGreaterElement(nums3, nums4); // Output: [3, -1]
        System.out.println(Arrays.toString(res2));
    }
}
