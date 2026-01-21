package week_2;

/*
 * Stack implementation using Array
 * Follows LIFO (Last In First Out) principle
 */
public class stack_implementation_array {

    /*
     * Stack class using array
     */
    static class stackArray {

        int[] stack;   // Array to store stack elements
        int size;      // Maximum size of stack
        int top;       // Index of top element

        /*
         * Constructor
         * Initializes stack with given size
         */
        stackArray(int size) {
            this.size = size;
            this.stack = new int[size]; // Allocate memory
            top = -1;                   // Stack is initially empty
        }

        /*
         * PUSH operation
         * Inserts an element into the stack
         */
        public void push(int value) {

            // Check for stack overflow
            if (top == size - 1) {
                System.out.println("Stack Overflow");
                return;
            }

            // Increment top and insert value
            stack[++top] = value;
        }

        /*
         * POP operation
         * Removes and returns top element
         */
        public int pop() {

            // Check for stack underflow
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }

            // Return top element and decrement top
            return stack[top--];
        }

        /*
         * PEEK operation
         * Returns top element without removing it
         */
        public int peek() {

            // Check if stack is empty
            if (top == -1) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return stack[top];
        }

        /*
         * Checks if stack is empty
         */
        public boolean isEmpty() {
            return top == -1;
        }

        /*
         * Checks if stack is full
         */
        public boolean isFull() {
            return top == size - 1;
        }

        /*
         * Displays all stack elements
         */
        public void display() {

            // If stack is empty
            if (top == -1) {
                System.out.println("Stack is Empty");
                return;
            }

            // Print stack from top to bottom
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Main method - Driver code
     */
    public static void main(String[] args) {

        // Create stack of size 5
        stackArray s = new stackArray(5);

        // Push elements
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        // Display stack
        s.display();

        // Pop elements
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        // Peek top element
        System.out.println("Peek: " + s.peek());

        // Display stack again
        s.display();
    }
}
