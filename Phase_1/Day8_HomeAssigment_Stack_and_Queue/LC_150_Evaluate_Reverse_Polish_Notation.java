package Day8_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_150_Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {
        // Example test case 1:
        // Expression: (2 + 1) * 3  => in RPN: ["2", "1", "+", "3", "*"]
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Output 1: " + evalRPN(tokens1)); // Expected: 9

        // Example test case 2:
        // Expression: 4 + (13 / 5) => in RPN: ["4", "13", "5", "/", "+"]
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Output 2: " + evalRPN(tokens2)); // Expected: 6

        // Example test case 3:
        // Expression: Complex nested operations
        // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        // Expected output: 22
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Output 3: " + evalRPN(tokens3));
    }

    /**
     * 🧩 Function to evaluate an arithmetic expression written in
     * Reverse Polish Notation (Postfix form)
     *
     * Rules:
     * - Operands (numbers) are pushed onto the stack.
     * - When an operator (+, -, *, /) is encountered:
     *     → Pop the top two operands from the stack.
     *     → Apply the operation.
     *     → Push the result back onto the stack.
     * - After all tokens are processed, the stack will have one element → the result.
     */
    public static int evalRPN(String[] tokens) {
        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Traverse each token in the expression
        for (String token : tokens) {

            switch (token) {
                case "+":
                    // Pop top two elements and add them
                    // Example: if stack = [2, 3] → push(2 + 3 = 5)
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    // Pop the top two operands in correct order (a - b)
                    int b1 = stack.pop(); // second operand (top of stack)
                    int a1 = stack.pop(); // first operand
                    stack.push(a1 - b1);  // push the result of subtraction
                    break;

                case "*":
                    // Pop top two operands and multiply them
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    // Pop top two operands in correct order (a / b)
                    int b2 = stack.pop(); // divisor
                    int a2 = stack.pop(); // dividend
                    // Integer division — truncates toward zero (same as Java default)
                    stack.push(a2 / b2);
                    break;

                default:
                    // If token is a number → convert to integer and push to stack
                    stack.push(Integer.parseInt(token));
            }
        }

        // After all operations, only the final result remains in the stack
        return stack.pop();
    }
}
