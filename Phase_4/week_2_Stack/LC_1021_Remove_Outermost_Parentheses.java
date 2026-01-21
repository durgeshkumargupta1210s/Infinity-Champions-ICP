package week_2;
import java.util.*;
public class LC_1021_Remove_Outermost_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()())(())";
		System.out.println(removeOuterParentheses(s));

	}
	// This method removes the outermost parentheses
    // from every primitive valid parentheses substring
    public static String removeOuterParentheses(String s) {

        // Stack to track the depth (nesting) of parentheses
        Stack<Character> st = new Stack<>();

        // StringBuilder to efficiently build the final result
        StringBuilder result = new StringBuilder();

        // Traverse each character of the input string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Case 1: Opening parenthesis '('
            if (ch == '(') {

                // If stack is NOT empty, this '(' is NOT an outermost one,
                // so it should be included in the result
                if (!st.isEmpty()) {
                    result.append(ch);
                }

                // Push '(' to increase the current nesting level
                st.push(ch);
            }
            // Case 2: Closing parenthesis ')'
            else {

                // Pop first to reduce the nesting level
                // This helps identify whether this ')' is outermost
                st.pop();

                // If stack is NOT empty after pop,
                // this ')' is NOT an outermost one
                // so it should be included in the result
                if (!st.isEmpty()) {
                    result.append(ch);
                }
            }
        }

        // Convert StringBuilder to String and return the result
        return result.toString();
    }

}
