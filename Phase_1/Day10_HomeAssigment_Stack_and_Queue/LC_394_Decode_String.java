package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_394_Decode_String {

    /**
     * Decode an encoded string with pattern k[encoded_string].
     * 
     * Logic:
     * - Use two stacks: one for counts (k), one for accumulated strings
     * - Iterate characters:
     *   - Digit: build the multiplier k
     *   - '[': push current k and string to stacks and reset current
     *   - ']': pop count and previous string, append current repeated count times
     *   - Letter: append to current string
     *
     * @param s - encoded string
     * @return decoded string
     */
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();           // Stack to store multipliers
        Stack<StringBuilder> stringStack = new Stack<>();   // Stack to store previous strings
        StringBuilder current = new StringBuilder();        // Current building string
        int k = 0;                                          // Current multiplier

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the multiplier (can be multiple digits)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push current multiplier and string onto stacks
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder(); // reset current string
                k = 0;                         // reset multiplier
            } else if (c == ']') {
                // Pop previous string and multiplier
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                // Append current string 'count' times
                for (int i = 0; i < count; i++) {
                    decoded.append(current);
                }
                current = decoded; // update current string
            } else {
                // Regular character, append to current string
                current.append(c);
            }
        }

        return current.toString();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(decodeString(s1)); // Output: "aaabcbc"
        System.out.println(decodeString(s2)); // Output: "accaccacc"
        System.out.println(decodeString(s3)); // Output: "abcabccdcdcdef"
    }
}
