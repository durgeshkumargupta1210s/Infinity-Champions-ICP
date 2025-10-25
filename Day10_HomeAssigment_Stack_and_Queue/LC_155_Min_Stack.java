package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

// ---------------------- MIN STACK CLASS ----------------------
/**
 * MinStack supports push, pop, top, and retrieving the minimum element in O(1) time.
 */
class MinStack {

    private Stack<Integer> stack;     // main stack to store all elements
    private Stack<Integer> minStack;  // auxiliary stack to keep track of minimums

    // Constructor: initialize both stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /**
     * Push element onto the stack
     * If val <= current minimum, also push to minStack
     */
    public void push(int val) {
        stack.push(val);
        // push to minStack if empty or val <= current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /**
     * Remove the top element from the stack
     * If it is equal to current min, also pop from minStack
     */
    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    /**
     * Get the top element of the stack
     */
    public int top() {
        return stack.peek();
    }
    
    /**
     * Retrieve the minimum element in the stack
     */
    public int getMin() {
        return minStack.peek();
    }
}

// ---------------------- TESTING ----------------------
public class LC_155_Min_Stack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Push elements
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // Retrieve current minimum
        System.out.println("Min: " + minStack.getMin()); // Output: -3

        // Pop top element
        minStack.pop();

        // Retrieve current top and minimum
        System.out.println("Top: " + minStack.top());    // Output: 0
        System.out.println("Min: " + minStack.getMin()); // Output: -2
    }
}
