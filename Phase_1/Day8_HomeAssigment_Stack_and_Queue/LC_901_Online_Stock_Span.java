package Day8_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_901_Online_Stock_Span {

    // Stack to store pairs of {price, span}
    // stack.peek()[0] -> stock price
    // stack.peek()[1] -> span of that stock price
    private Stack<int[]> stack;

    // Constructor: initializes the stack
    public LC_901_Online_Stock_Span() {
        stack = new Stack<>();
    }

    /**
     * Function to process the next stock price and calculate its span
     *
     * Stock span definition:
     * Span of the stock’s price today = number of consecutive days
     * (including today) the price of the stock was less than or equal to today’s price.
     *
     * @param price - Today's stock price
     * @return span - Number of consecutive days with price ≤ today
     */
    public int next(int price) {
        int span = 1; // Minimum span is 1 (today itself)

        // While there are previous prices ≤ current price
        // we can "merge" their spans into the current span
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1]; // Add their span to current span
            stack.pop();             // Remove them from stack as they're included
        }

        // Push current price and its span onto the stack
        stack.push(new int[]{price, span});

        // Return the calculated span
        return span;
    }

    // -------------------- TESTING --------------------
    public static void main(String[] args) {
        LC_901_Online_Stock_Span obj = new LC_901_Online_Stock_Span();

        // Example sequence of stock prices
        System.out.println(obj.next(100)); // returns 1 → no previous price ≤ 100
        System.out.println(obj.next(80));  // returns 1 → no previous price ≤ 80
        System.out.println(obj.next(60));  // returns 1 → no previous price ≤ 60
        System.out.println(obj.next(70));  // returns 2 → includes 60, 70 > 60
        System.out.println(obj.next(60));  // returns 1 → 60 alone
        System.out.println(obj.next(75));  // returns 4 → includes 60, 70, 60
        System.out.println(obj.next(85));  // returns 6 → includes 75, 60, 70, 60, 80
    }
}
