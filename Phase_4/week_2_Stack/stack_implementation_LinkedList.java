package week_2;

/*
 * Stack implementation using Singly Linked List
 * Follows LIFO (Last In First Out) principle
 */
public class stack_implementation_LinkedList {

    /*
     * Stack class
     * Maintains reference to the top node
     */
    static class stackLinkedList {

        // Pointer to the top of the stack
        private Node top;

        // Constructor: initializes empty stack
        public stackLinkedList() {
            top = null;
        }

        /*
         * PUSH operation
         * Inserts an element at the top of the stack
         */
        public void push(int data) {

            // Create a new node with given data
            Node nn = new Node(data);

            // Link new node to current top
            nn.next = top;

            // Update top to point to new node
            top = nn;
        }

        /*
         * POP operation
         * Removes and returns the top element of the stack
         */
        public int pop() {

            // Check for stack underflow
            if (top == null) {
                throw new RuntimeException("Stack Underflow");
            }

            // Store top element value
            int value = top.data;

            // Move top to next node
            top = top.next;

            // Return removed value
            return value;
        }

        /*
         * PEEK operation
         * Returns top element without removing it
         */
        public int peek() {

            // Check if stack is empty
            if (top == null) {
                throw new RuntimeException("Stack is Empty");
            }

            // Return top element
            return top.data;
        }

        /*
         * Checks whether the stack is empty
         */
        public boolean isEmpty() {
            return top == null;
        }
    }

    /*
     * Node class for linked list
     * Each node contains data and reference to next node
     */
    static class Node {

        int data;     // Value stored in node
        Node next;    // Reference to next node

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Main method: driver code
     */
    public static void main(String[] args) {

        // Create stack object
        stackLinkedList st = new stackLinkedList();

        // Push elements into stack
        st.push(20);
        st.push(40);
        st.push(80);

        // Pop top element
        System.out.println(st.pop());   // Output: 80

        // Peek top element
        System.out.println(st.peek());  // Output: 40
    }
}
