package week_2;
import java.util.*;
public class LC_739_Daily_Temperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

	}
	public static int[] dailyTemperatures(int[] temp) {

        // Result array:
        // result[i] = number of days until a warmer temperature after day i
        int[] result = new int[temp.length];

        // Stack to store indices of temperatures
        // It maintains a decreasing monotonic stack
        Stack<Integer> st = new Stack<>();

        // Traverse the temperature array
        for (int i = 0; i < temp.length; i++) {

            int val = temp[i];

            // While stack is not empty and current temperature
            // is higher than the temperature at the index
            // stored at the top of the stack
            while (!st.isEmpty() && temp[st.peek()] < val) {

                // Pop the index for which we found a warmer day
                int idx = st.pop();

                // The number of days waited is the difference in indices
                result[idx] = i - idx;
            }

            // Push the current day's index onto the stack
            // Waiting for a warmer temperature in future days
            st.push(i);
        }

        // Indices left in the stack do not have any warmer future day
        // Their result values remain 0 by default
        return result;
    }

}
