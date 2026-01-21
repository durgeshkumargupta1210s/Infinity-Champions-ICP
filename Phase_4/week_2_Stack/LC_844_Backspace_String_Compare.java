package week_2;
import java.util.*;
public class LC_844_Backspace_String_Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab#c", t = "ad#c";
		System.out.println(backspaceCompare(s,t));

	}
	public static boolean backspaceCompare(String s, String t) {

        // Stack to process string s
        Stack<Character> st1 = new Stack<>();

        // Stack to process string t
        Stack<Character> st2 = new Stack<>();

        // Process string s character by character
        for (char ch : s.toCharArray()) {

            // '#' represents a backspace operation
            if (ch == '#') {

                // Remove the last character if stack is not empty
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } 
            // Normal character: push onto the stack
            else {
                st1.push(ch);
            }
        }

        // Process string t character by character
        for (char ch : t.toCharArray()) {

            // '#' represents a backspace operation
            if (ch == '#') {

                // Remove the last character if stack is not empty
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            } 
            // Normal character: push onto the stack
            else {
                st2.push(ch);
            }
        }

        // Compare final processed stacks
        // Stack.equals() checks both size and element order
        return st1.equals(st2);
    }

}
