package week_2;
import java.util.*;
public class GFG_Help_Classmates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int arr[] = {3, 8, 5, 2, 25};
		System.out.println(help_classmate(arr,N));

	}
	public static int[] help_classmate(int arr[], int n) {

        // Stack to store indices of elements
        Stack<Integer> st = new Stack<>();

        // Result array to store nearest smaller elements
        int[] result = new int[arr.length];

        // Traverse the array from left to right
        for (int i = 0; i < arr.length; i++) {

            /*
             While current element is smaller than the element
             at the index stored on top of the stack,
             it becomes the nearest smaller element to the right
             */
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                result[st.pop()] = arr[i];
            }

            // Push current index onto the stack
            st.push(i);
        }

        /*
         Elements left in the stack do not have any smaller
         element to their right
         */
        while (!st.isEmpty()) {
            result[st.pop()] = -1;
        }

        // Return the final result array
        return result;
    }

}
