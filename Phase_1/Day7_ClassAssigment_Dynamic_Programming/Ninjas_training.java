package Day7_ClassAssigment_Dynamic_Programming;

public class Ninjas_training {

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };
        int n = matrix.length;

        // Start recursion from the last day with no restriction (last = 3)
        System.out.println(calculatePoints(matrix, n - 1, 3));
        System.out.println(calculatePointsBU(matrix)); // Expected Output: 210
    }

    /**
     * Bottom-Up Dynamic Programming (Tabulation)
     * ------------------------------------------------
     * dp[day][last] → Maximum points up to day 'day'
     * if 'last' task was done on the previous day.
     * 
     * last ∈ {0, 1, 2, 3}, where 3 means "no restriction".
     */
    private static int calculatePointsBU(int[][] matrix) {
        int n = matrix.length;

        // Create DP table with dimensions [n][4]
        int[][] dp = new int[n][4];

        // Base Case Initialization for day 0
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Fill the table for remaining days
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // initialize current state
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = matrix[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        // Final answer is at last day with 'no restriction' (3)
        return dp[n - 1][3];
    }	

	// Recursive function to calculate maximum points
    private static int calculatePoints(int[][] matrix, int days, int last) {
        
        // Base Case: When we're on the first day (day = 0)
        // Pick the best task that is NOT equal to 'last'
        if (days == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, matrix[days][task]);
                }
            }
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;

        // Try all possible tasks for the current day
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                // If we pick 'task' today, it becomes 'last' for the previous day
                int points = matrix[days][task] + calculatePoints(matrix, days - 1, task);
                maxi = Math.max(maxi, points);
            }
        }

        // Return the maximum points achievable
        return maxi;
    }
    
}
