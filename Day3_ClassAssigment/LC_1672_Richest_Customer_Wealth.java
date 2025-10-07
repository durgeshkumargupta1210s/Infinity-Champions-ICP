package Day3_ClassAssigment;

public class LC_1672_Richest_Customer_Wealth {

	public static void main(String[] args) {
		// Sample input: Each row represents a customer,
		// and each column represents their wealth in a bank.
		int [][]accounts = {
			{1, 5},   // Customer 1 has 1 + 5 = 6
			{7, 3},   // Customer 2 has 7 + 3 = 10
			{3, 5}    // Customer 3 has 3 + 5 = 8
		};

		// Call the method and print the result
		// Expected Output: 10 (richest customer wealth)
		System.out.println(maximumWealth(accounts));
	}

	// Method to find the maximum wealth among all customers
	public static int maximumWealth(int[][] accounts) {
        int ans = 0; // Variable to keep track of the richest customer's wealth

		// Iterate through each customer's account array
        for (int[] arr : accounts) {
            int sum = 0; // Sum of current customer's wealth

			// Add all the bank balances for the current customer
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

			// Update the richest wealth if this customer's wealth is greater
            ans = Math.max(ans, sum);
        }

		// Return the maximum wealth found
        return ans;
    }
}
