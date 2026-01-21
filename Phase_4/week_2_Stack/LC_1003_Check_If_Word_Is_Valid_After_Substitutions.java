package week_2;
import java.util.*;
public class LC_1003_Check_If_Word_Is_Valid_After_Substitutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcababcc";
		
		// Stack to store characters while processing the string
        Stack<Character> st = new Stack<>();

        // Traverse each character in the string
        for (char ch : s.toCharArray()) {

            // Push current character onto the stack
            st.push(ch);

            // Check only when stack has at least 3 characters
            // because we are looking for the pattern "abc"
            if (st.size() >= 3) {

                int n = st.size();

                // Check if the top three characters form "abc"
                if (st.get(n - 3) == 'a' &&
                    st.get(n - 2) == 'b' &&
                    st.get(n - 1) == 'c') {

                    // Remove "abc" from the stack
                    st.pop(); // removes 'c'
                    st.pop(); // removes 'b'
                    st.pop(); // removes 'a'
                }
            }
        }

        // If stack is empty, all "abc" patterns were successfully removed
        if (st.isEmpty()) {
        	System.out.println(true);
        }
        else {
        	System.out.println(false);
        }
	}

}
