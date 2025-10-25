package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_227_Basic_Calculator_II {

    /**
     * Evaluate a basic arithmetic expression containing +, -, *, / (no parentheses)
     *
     * Logic:
     * - Use a stack to handle numbers and operators
     * - For '+' and '-', push number (or its negative) onto stack
     * - For '*' and '/', compute with top of stack and push result
     * - Finally, sum all values in the stack
     *
     * @param s - input arithmetic expression
     * @return evaluated result
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); // stack to handle numbers
        int num = 0;                           // current number being formed
        char sign = '+';                        // previous operator, initialized to '+'
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Build multi-digit number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // If current character is operator (or last character), process previous sign
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);       // push positive number
                        break;
                    case '-':
                        stack.push(-num);      // push negative number
                        break;
                    case '*':
                        stack.push(stack.pop() * num); // multiply with top of stack
                        break;
                    case '/':
                        stack.push(stack.pop() / num); // divide with top of stack
                        break;
                }
                sign = c; // update operator
                num = 0;  // reset number for next iteration
            }
        }

        // Sum all values in stack to get final result
        int result = 0;
        for (int val : stack) {
            result += val;
        }

        return result;
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        String expr1 = "3+2*2";
        String expr2 = " 3/2 ";
        String expr3 = " 3+5 / 2 ";

        System.out.println(calculate(expr1)); // Output: 7
        System.out.println(calculate(expr2)); // Output: 1
        System.out.println(calculate(expr3)); // Output: 5
    }
}
