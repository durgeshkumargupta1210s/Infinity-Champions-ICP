package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_1209_Remove_All_Adjacent_Duplicates_in_String_II {

    /**
     * Helper class to store character and its consecutive count
     */
    static class Pair {
        char c;    // character
        int count; // consecutive occurrences

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    /**
     * Remove all adjacent duplicates in string where duplicates appear k times consecutively.
     *
     * Logic:
     * - Use a stack to keep track of characters and their consecutive counts
     * - For each character:
     *   - If same as top of stack, increment count
     *   - Otherwise, push new Pair with count 1
     *   - If count reaches k, pop from stack (remove duplicates)
     * - Finally, rebuild string from stack
     *
     * @param s input string
     * @param k number of consecutive duplicates to remove
     * @return string after removing duplicates
     */
    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                // Increment count for consecutive character
                stack.peek().count++;
            } else {
                // Push new character with count 1
                stack.push(new Pair(c, 1));
            }

            // If count reaches k, remove from stack
            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        // Rebuild the final string from stack
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }
        }

        return sb.toString();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        String s1 = "deeedbbcccbdaa";
        int k1 = 3;
        System.out.println(removeDuplicates(s1, k1)); // Output: "aa"

        String s2 = "pbbcggttciiippooaais";
        int k2 = 2;
        System.out.println(removeDuplicates(s2, k2)); // Output: "ps"
    }
}
