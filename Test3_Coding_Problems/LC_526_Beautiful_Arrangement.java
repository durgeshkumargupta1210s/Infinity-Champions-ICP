package Test3_Coding_Problems;

public class LC_526_Beautiful_Arrangement {

    // Make count static so it can be accessed inside static methods
    static int count = 0;

    public static void main(String[] args) {
        int n = 2;

        // Boolean array to mark which numbers are already used in the current arrangement
        boolean[] visited = new boolean[n];

        // Start recursive generation from position 1
        countBeautifulPermutation(n, visited, 1);

        // Print the final count of beautiful arrangements
        System.out.println("Number of beautiful arrangements: " + count);
    }

    /**
     * Recursive function to count the number of beautiful permutations.
     * @param n total numbers (1 to n)
     * @param visited keeps track of numbers already used
     * @param position current position (1-indexed)
     */
    private static void countBeautifulPermutation(int n, boolean[] visited, int position) {
    	// Base case: if all positions have been filled (position > n)
        // it means we found a valid arrangement
        if (position > n) {
            count++;
            return;
        }
        
        // Try placing each number (1 to n) at the current position
        for (int i = 1; i <= n; i++) {
            // Check if number 'i' is not already used
            // AND it satisfies the beautiful arrangement condition:
            // (number divisible by position OR position divisible by number)
            if (!visited[i - 1] && (i % position == 0 || position % i == 0)) {

                // Choose the number 'i' for this position
                visited[i - 1] = true;

                // Recurse for the next position
                countBeautifulPermutation(n,visited, position + 1);

                // Backtrack: unmark number 'i' to use it in other permutations
                visited[i - 1] = false;
            }
        }
    }
}
