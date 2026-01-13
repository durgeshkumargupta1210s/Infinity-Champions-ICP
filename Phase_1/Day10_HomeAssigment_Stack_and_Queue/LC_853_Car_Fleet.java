package Day10_HomeAssigment_Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class LC_853_Car_Fleet {

    /**
     * Calculate the number of car fleets that will arrive at the target.
     *
     * Logic:
     * - Pair each car's position and speed
     * - Sort cars by starting position in descending order (closest to target first)
     * - Compute time to reach target for each car
     * - Use a stack to track fleets: if a car takes longer than the fleet ahead, it forms a new fleet
     *
     * @param target - the target position
     * @param position - starting positions of cars
     * @param speed - speeds of cars
     * @return number of fleets
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        // Step 1: Pair position and speed
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Step 2: Sort cars by position in descending order
        // This ensures we process cars starting closer to the target first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>(); // Stack to track fleet times

        // Step 3: Calculate fleet formation
        for (int i = 0; i < n; i++) {
            // Time = distance / speed
            double time = (double)(target - cars[i][0]) / cars[i][1];

            // If stack is empty or current car takes longer than fleet ahead, it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Else, the car joins the fleet ahead (do nothing)
        }

        // Step 4: Number of fleets = size of stack
        return stack.size();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println("Number of Car Fleets: " + carFleet(target, position, speed)); // Output: 3
    }
}
