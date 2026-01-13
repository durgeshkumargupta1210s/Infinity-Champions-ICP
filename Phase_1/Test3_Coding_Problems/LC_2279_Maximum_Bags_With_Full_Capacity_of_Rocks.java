package Test3_Coding_Problems;

import java.util.*;

public class LC_2279_Maximum_Bags_With_Full_Capacity_of_Rocks {

	public static void main(String[] args) {
		// Example input
		int[] capacity = {2, 3, 4, 5};
		int[] rocks = {1, 2, 4, 4};
		int additionalRocks = 2;

		// Call the function and print the result
		System.out.println(maximumBags(capacity, rocks, additionalRocks));
	}

	/**
	 * This method calculates the maximum number of bags that can be filled
	 * to their full capacity by distributing the additional rocks optimally.
	 *
	 * @param capacity        array representing the capacity of each bag
	 * @param rocks           array representing the number of rocks already in each bag
	 * @param additionalRocks the total number of extra rocks available to distribute
	 * @return the maximum number of bags that can be completely filled
	 */
	public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		int n = rocks.length;
		int[] need = new int[n];

		// Step 1: Calculate how many more rocks each bag needs to be full
		for (int i = 0; i < n; i++) {
			need[i] = capacity[i] - rocks[i];
		}

		// Step 2: Sort the 'need' array so we can fill the bags that need fewer rocks first
		Arrays.sort(need);

		int count = 0; // to keep track of how many bags are full

		// Step 3: Distribute additional rocks greedily
		for (int i = 0; i < n; i++) {
			if (need[i] == 0) {
				// Bag is already full
				count++;
			} else if (additionalRocks >= need[i]) {
				// We have enough rocks to fill this bag
				additionalRocks -= need[i];
				count++;
			} else {
				// We don't have enough rocks to fill this bag or any that need more
				break;
			}
		}

		// Step 4: Return the total number of full bags
		return count;
	}
}
