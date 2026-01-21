package week_2;
import java.util.*;
public class LC_503_Next_Greater_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,3,4,3};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));

	}
	public static int[] nextGreaterElements(int[] nums) {

        // Result array to store the next greater element for each index
        int[] result = new int[nums.length];

        // Initialize result array with -1
        // If no greater element exists, -1 will remain
        Arrays.fill(result, -1);

        // Stack to store indices of elements
        // The stack maintains a decreasing order of values
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice to simulate circular behavior
        for (int i = 0; i < nums.length * 2; i++) {

            // Use modulo to wrap around the array
            int idx = i % nums.length;
            int val = nums[idx];

            // While stack is not empty and current value is greater
            // than the value at the index stored at the top of the stack
            while (!st.isEmpty() && nums[st.peek()] < val) {

                // Current value is the next greater element
                // for the index popped from the stack
                result[st.pop()] = val;
            }

            // Push index into stack only during the first pass
            // This avoids duplicate indices and ensures correctness
            if (i < nums.length) {
                st.push(idx);
            }
        }

        // Remaining indices in the stack do not have a next greater element
        // Their values remain -1 (already initialized)
        while (!st.isEmpty()) {
            result[st.pop()] = -1;
        }

        // Return the result array
        return result;
    }

}
