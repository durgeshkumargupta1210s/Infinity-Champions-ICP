package Day5_ClassAssigment_Greedy;

public class GFG_Minimum_number_of_Coins {

	public static void main(String[] args) {
		// Test case: find the minimum number of coins/notes required for amount = 39
		int n = 39;
		System.out.println(findMin(n));  // Expected output: 6 (10+10+10+5+2+2)
	}

	// Function to find the minimum number of coins/notes to make the amount 'n'
	public static int findMin(int n) {
		int count = 0;  // variable to store total number of coins/notes used

		// Step 1: Use the maximum possible 10-unit notes first
		count += n / 10;  // number of 10-unit notes
		n = n % 10;       // remaining amount after using 10-unit notes

		// Step 2: Use the maximum possible 5-unit notes
		count += n / 5;   // number of 5-unit notes
		n = n % 5;        // remaining amount after using 5-unit notes

		// Step 3: Use the maximum possible 2-unit coins
		count += n / 2;   // number of 2-unit coins
		n = n % 2;        // remaining amount after using 2-unit coins

		// Step 4: Use the remaining 1-unit coins (if any)
		count += n;       // since n can only be 0 or 1 at this point

		// Return the total number of coins/notes used
		return count;
	}
}
