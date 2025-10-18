package Day5_ClassAssigment;

import java.util.*;

public class LC_1710_Maximum_Units_on_a_Truck {

	public static void main(String[] args) {
		// Example input
		int[][] boxTypes = { {1, 3}, {2, 2}, {3, 1} };
		int truckSize = 4;

		// Call the function and print the result
		System.out.println(maximumUnits(boxTypes, truckSize));
	}

	/**
	 * Function to calculate the maximum number of units that can be
	 * loaded onto the truck.
	 *
	 * Each element in boxTypes is of the form [numberOfBoxes, unitsPerBox].
	 * The truck can carry at most 'truckSize' number of boxes.
	 * We use a greedy approach: always pick boxes with the highest units per box first.
	 *
	 * @param boxTypes  2D array representing different box types
	 * @param truckSize Maximum number of boxes the truck can carry
	 * @return Maximum total units that can be loaded onto the truck
	 */
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		// Sort the box types by units per box in descending order
		// This ensures that we always pick the most "valuable" boxes first
		Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

		int total = 0; // To store the total number of units loaded onto the truck

		// Traverse through the sorted box types
		for (int i = 0; i < boxTypes.length; i++) {
			int noOfBoxes = boxTypes[i][0]; // Number of boxes available for this type
			int units = boxTypes[i][1];     // Number of units per box for this type

			// If the truck is already full, stop processing further
			if (truckSize == 0) break;

			if (noOfBoxes <= truckSize) {
				// Truck can take all boxes of this type
				total += noOfBoxes * units;    // Add all units
				truckSize -= noOfBoxes;       // Reduce truck capacity accordingly
			} else {
				// Truck can only take a fraction of this box type (based on remaining space)
				total += truckSize * units;   // Take as many boxes as fit
				truckSize = 0;                // Truck is now full
			}
		}

		// Return the total number of units loaded onto the truck
		return total;
	}
}
