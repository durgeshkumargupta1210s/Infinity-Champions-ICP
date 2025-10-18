package Day5_ClassAssigment;

import java.util.*;

public class GFG_Fractional_Knapsack {

	public static void main(String[] args) {
		// Sample input values
		int val[] = {60, 100, 120};   // Values of the items
		int wt[] = {10, 20, 30};      // Corresponding weights of the items
		int capacity = 50;            // Maximum capacity of the knapsack

		// Call the fractionalKnapsack function and print the maximum value
		System.out.println(fractionalKnapsack(val, wt, capacity));
	}

	/**
	 * Function to calculate the maximum total value that can be obtained
	 * by placing items (or fractions of items) in the knapsack.
	 * Uses a greedy approach, sorting by value-to-weight ratio.
	 *
	 * @param val Array of item values
	 * @param wt Array of item weights
	 * @param capacity Maximum capacity of the knapsack
	 * @return Maximum value achievable
	 */
	public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
		// Create a 2D array to store value and weight for each item
		double[][] arr = new double[val.length][2];
		for (int i = 0; i < val.length; i++) {
			arr[i][0] = val[i];  // Store value in column 0
			arr[i][1] = wt[i];   // Store weight in column 1
		}

		// Sort the array based on value-to-weight ratio in descending order
		Arrays.sort(arr, (a, b) -> {
			double r1 = a[0] / a[1];  // Ratio for item a
			double r2 = b[0] / b[1];  // Ratio for item b
			return Double.compare(r2, r1);  // Descending order
		});

		double total = 0.0;  // Variable to store total value collected

		// Traverse the sorted array and add items to the knapsack
		for (int i = 0; i < arr.length; i++) {
			double value = arr[i][0];
			double weight = arr[i][1];

			if (capacity >= weight) {
				// If the current item can be taken fully
				total += value;
				capacity -= weight;
			} else {
				// Take the fraction of the remaining capacity
				total += (value / weight) * capacity;
				break; // Knapsack is now full
			}
		}

		// Return the maximum value that can be carried
		return total;
	}
}
