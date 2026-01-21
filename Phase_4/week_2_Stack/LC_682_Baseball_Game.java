package week_2;
import java.util.*;
public class LC_682_Baseball_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []ops = {"5","-2","4","C","D","9","+","+"};
		
		
		System.out.println(calPoints(ops));

	}
	public static int calPoints(String[] operations) {

        // Stack to store valid round scores
        Stack<Integer> st = new Stack<>();

        // Process each operation one by one
        for (String ch : operations) {

            // "+" operation:
            // Sum of the previous two valid scores
            if (ch.equals("+")) {

                // Remove last score to access second last
                int last = st.pop();
                int secondLast = st.peek();

                // Restore the last score
                st.push(last);

                // Push sum of last two scores
                st.push(last + secondLast);
            }

            // "D" operation:
            // Double the previous valid score
            else if (ch.equals("D")) {
                st.push(2 * st.peek());
            }

            // "C" operation:
            // Invalidate and remove the previous valid score
            else if (ch.equals("C")) {
                st.pop();
            }

            // Numeric value:
            // Push the score directly onto the stack
            else {
                st.push(Integer.parseInt(ch));
            }
        }

        // Calculate the total score by summing all values in the stack
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }

}
