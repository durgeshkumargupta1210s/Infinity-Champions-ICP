package Test3_Coding_Problems;

import java.util.*;

public class LC_1544_Make_The_String_Great {

    public static void main(String[] args) {
        // Input string
        String s = "leEeetcode";

        // Step 1: Use a stack to process the string
        // We'll remove pairs of adjacent letters that are the same character but different cases
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Step 2: Check if the current character 'ch' and the top of the stack form a "bad" pair
            // A bad pair occurs when one is uppercase and the other is lowercase of the same letter
            // ASCII difference between lowercase and uppercase is 32
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop(); // Remove the bad pair from the stack
            } else {
                st.push(ch); // Otherwise, push the current character onto the stack
            }
        }

        // Step 3: Build the resulting "great" string from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop()); // Pop characters from stack and append
        }

        // Step 4: Reverse the string because stack pops in reverse order
        System.out.println(sb.reverse().toString()); // Output the final string
    }
}
