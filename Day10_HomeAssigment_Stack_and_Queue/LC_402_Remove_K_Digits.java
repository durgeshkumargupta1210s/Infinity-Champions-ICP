package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class LC_402_Remove_K_Digits {

    /**
     * Remove k digits from the number string to get the smallest possible number
     *
     * Logic:
     * - Use a stack to keep digits in increasing order
     * - If the current digit is smaller than the top of the stack, pop from stack
     * - After processing all digits, remove remaining k digits from the end
     * - Build the final number from the stack
     * - Remove leading zeros
     *
     * @param num - input number as string
     * @param k - number of digits to remove
     * @return smallest number as string after removing k digits
     */
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>(); // stack to store digits

        // Step 1: Process each digit
        for (char digit : num.toCharArray()) {
            // Remove digits from stack if they are greater than current digit
            // and we still have digits to remove
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit); // add current digit to stack
        }

        // Step 2: If k > 0, remove remaining digits from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        // Step 3: Build the final number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        // Step 4: Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Step 5: If the string is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        String num1 = "1432219";
        int k1 = 3;
        System.out.println(removeKdigits(num1, k1)); // Output: "1219"

        String num2 = "10200";
        int k2 = 1;
        System.out.println(removeKdigits(num2, k2)); // Output: "200"

        String num3 = "10";
        int k3 = 2;
        System.out.println(removeKdigits(num3, k3)); // Output: "0"
    }
}
