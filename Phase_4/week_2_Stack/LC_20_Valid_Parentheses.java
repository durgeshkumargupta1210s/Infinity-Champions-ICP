package week_2;
import java.util.*;
public class LC_20_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()[]{}";
		// Stack to store opening brackets
        Stack<Character> st = new Stack<>();
        boolean ans=false;

        // Traverse each character of the string
        for (char ch : s.toCharArray()) {

            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                // If a closing bracket is found and stack is empty,
                // there is no matching opening bracket
                if (st.isEmpty()) {
                    ans=false;
                    break;
                }

                // Check whether the closing bracket matches the top of the stack
                if (
                    (ch == ')' && st.peek() != '(') ||
                    (ch == '}' && st.peek() != '{') ||
                    (ch == ']' && st.peek() != '[')
                ) {
                   ans=false;
                   break;
                }

                // If matched, remove the opening bracket from the stack
                st.pop();
            }
        }

        // If stack is empty, all brackets were properly matched
        if(st.isEmpty()) {
        	ans=true;
        }
        System.out.println(ans);

	}

}
