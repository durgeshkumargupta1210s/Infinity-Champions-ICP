package Day10_HomeAssigment_Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

// ---------------------- MY STACK CLASS ----------------------
/**
 * Implement a stack using a single queue
 * Stack operations: push, pop, top, empty
 */
class MyStack {

    private Queue<Integer> queue;  // main queue to simulate stack

    // Constructor: initialize the queue
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /**
     * Push element onto stack
     * To maintain stack order:
     * - Add element to queue
     * - Rotate all elements before it to the back
     */
    public void push(int x) {
        queue.add(x);           // enqueue element
        int size = queue.size();
        // Rotate the previous elements behind the new element
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove()); // dequeue and enqueue to rotate
        }
    }
    
    /**
     * Remove the element on top of the stack
     * Equivalent to dequeue the front of queue after rotation
     */
    public int pop() {
        return queue.remove();
    }
    
    /**
     * Get the top element of the stack
     * Equivalent to peek the front of queue after rotation
     */
    public int top() {
        return queue.peek();
    }
    
    /**
     * Check whether the stack is empty
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

// ---------------------- TESTING ----------------------
public class LC_225_Implement_Stack_using_Queues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Push elements
        stack.push(1);
        stack.push(2);

        // Retrieve top element
        System.out.println(stack.top());   // Output: 2

        // Pop top element
        System.out.println(stack.pop());   // Output: 2

        // Check if stack is empty
        System.out.println(stack.empty()); // Output: false
    }
}
