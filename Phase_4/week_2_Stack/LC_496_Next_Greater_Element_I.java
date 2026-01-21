package week_2;
import java.util.*;
public class LC_496_Next_Greater_Element_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {4,1,2}, nums2 = {1,3,4,2};
		System.out.println(nextGreaterElement(nums1,nums2));

	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stack to maintain a decreasing sequence of elements
        Stack<Integer> st = new Stack<>();

        // Map to store next greater element for each number in nums2
        Map<Integer, Integer> map = new HashMap<>();

        /*
         Traverse nums2:
         - Maintain a monotonic decreasing stack
         - When current number is greater than stack top,
           it becomes the "next greater element" for popped values
        */
        for (int num : nums2) {

            // Resolve next greater element for smaller or equal elements
            while (!st.isEmpty() && st.peek() <= num) {
                map.put(st.pop(), num);
            }

            // Push current element into stack
            st.push(num);
        }

        // Remaining elements in stack do not have a next greater element
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Prepare the result array for nums1
        int[] ans = new int[nums1.length];

        // Fill result using precomputed values from the map
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

}
