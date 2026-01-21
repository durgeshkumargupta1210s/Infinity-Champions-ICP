package week_2;
import java.util.*;
public class LC_155_Min_Stack {
	
	static class MinStack {

	    // Main stack to store all values
	    private Stack<Integer> stack;

	    // Auxiliary stack to store the minimum values
	    // The top of this stack always contains the current minimum
	    private Stack<Integer> minStack;

	    // Constructor: initialize both stacks
	    public MinStack() {
	        stack = new Stack<>();
	        minStack = new Stack<>();
	    }

	    // Push a value onto the stack
	    public void push(int val) {

	        // Always push the value into the main stack
	        stack.push(val);

	        // Push into minStack ONLY if:
	        // 1. minStack is empty (first element)
	        // 2. val is smaller than or equal to the current minimum
	        // This ensures minStack always tracks the minimum values
	        if (minStack.isEmpty() || val <= minStack.peek()) {
	            minStack.push(val);
	        }
	    }

	    // Remove the top element from the stack
	    public void pop() {

	        // Remove the top element from the main stack
	        int val = stack.pop();

	        // If the removed element is equal to the current minimum,
	        // remove it from minStack as well
	        // This keeps both stacks in sync
	        if (val == minStack.peek()) {
	            minStack.pop();
	        }
	    }

	    // Return the top element of the stack (without removing it)
	    public int top() {
	        return stack.peek();
	    }

	    // Return the minimum element in the stack in O(1) time
	    public int getMin() {
	        return minStack.peek();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);

		System.out.println(obj.getMin());   // returns -3
		obj.pop();
		System.out.println(obj.top());      // returns 0
		System.out.println(obj.getMin());   // returns -2
	


	}

}
