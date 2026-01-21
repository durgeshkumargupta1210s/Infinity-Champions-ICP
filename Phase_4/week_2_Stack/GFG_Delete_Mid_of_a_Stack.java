package week_2;

import java.util.Stack;

public class GFG_Delete_Mid_of_a_Stack {

    public static void main(String[] args) {

        // Creating input stack:-
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        // Calling deleteMid function
        deleteMid(s);
        

        // Note:
        // Stack will be empty after execution because
        // elements are popped and not restored
    }

    // Function to delete the middle element of a stack
    public static void deleteMid(Stack<Integer> s) {

        // Index of middle element (0-based from bottom)
        int idx = s.size() / 2;

        // Counter to track popped elements
        int c = -1;

        // Loop until stack becomes empty
        while (!s.isEmpty()) {
            c++;

            // When counter reaches middle index,
            // pop the middle element and skip it
            if (c == idx) {
                s.pop();   // middle element removed
                continue;
            }

            // Pop and print remaining elements
            System.out.print(s.pop() + " ");
        }
    }
}
