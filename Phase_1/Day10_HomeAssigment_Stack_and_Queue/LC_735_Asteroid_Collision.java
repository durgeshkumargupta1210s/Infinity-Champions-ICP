package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_735_Asteroid_Collision {

    /**
     * Simulate asteroid collisions and return the state after all collisions.
     * 
     * Rules:
     * - Positive asteroid moves right, negative moves left
     * - Asteroids collide if one is moving right and next is moving left
     * - Smaller asteroid explodes, equal-sized asteroids both explode
     *
     * @param asteroids - array of asteroids
     * @return array after all collisions
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // stack to track asteroids moving right

        for (int ast : asteroids) {
            boolean destroyed = false; // flag to check if current asteroid is destroyed

            // Check for collisions: stack top moving right (>0) and current asteroid moving left (<0)
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -ast) {
                    // top asteroid explodes, continue checking next in stack
                    stack.pop();
                } else if (top == -ast) {
                    // both asteroids explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            // If current asteroid survives, push to stack
            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array for final result
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        int[] asteroids1 = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10, 2, -5};

        int[] res1 = asteroidCollision(asteroids1); // Output: [5, 10]
        int[] res2 = asteroidCollision(asteroids2); // Output: []
        int[] res3 = asteroidCollision(asteroids3); // Output: [10]

        // Print results
        for (int val : res1) System.out.print(val + " "); 
        System.out.println();
        for (int val : res2) System.out.print(val + " "); 
        System.out.println();
        for (int val : res3) System.out.print(val + " "); 
        System.out.println();
    }
}
