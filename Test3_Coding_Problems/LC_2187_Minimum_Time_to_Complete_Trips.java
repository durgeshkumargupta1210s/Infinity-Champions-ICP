package Test3_Coding_Problems;

public class LC_2187_Minimum_Time_to_Complete_Trips {

    public static void main(String[] args) {
        // Example input
        int[] time = {1, 2, 3};      // Time each bus takes to complete one trip
        int totalTrips = 5;           // Total trips needed

        // Call the function and print the minimum time required
        System.out.println(minimumTime(time, totalTrips)); // Expected output: 3
    }

    /**
     * Function to find the minimum time required to complete totalTrips
     * using all buses in the 'time' array.
     *
     * @param time       Array of times for each bus
     * @param totalTrips Total trips that must be completed
     * @return Minimum time to complete all trips
     */
    public static long minimumTime(int[] time, int totalTrips) {
        // Step 1: Find the minimum time among all buses (fastest bus)
        long minTime = Long.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        // Step 2: Set binary search boundaries
        long low = 1;                            // Minimum possible time
        long high = minTime * (long) totalTrips; // Maximum possible time
        long ans = 0;                             // To store the final answer

        // Step 3: Binary search to find the minimum valid time
        while (low <= high) {
            long mid = low + (high - low) / 2;   // Prevent overflow

            // Step 4: Calculate total trips that can be completed in 'mid' time
            long calculatedTrips = calculateTrip(time, mid);

            if (calculatedTrips >= totalTrips) {
                // If we can complete enough trips, try smaller time
                ans = mid;
                high = mid - 1;
            } else {
                // If not enough trips, increase the time
                low = mid + 1;
            }
        }

        // Step 5: Return the minimum time found
        return ans;
    }

    /**
     * Helper function to calculate the total number of trips
     * completed by all buses in given time 't'.
     *
     * @param time Array of times for each bus
     * @param t    Time duration
     * @return Total trips completed in 't' time
     */
    public static long calculateTrip(int[] time, long t) {
        long sum = 0;

        // Sum the trips completed by each bus
        for (int i = 0; i < time.length; i++) {
            sum += t / time[i]; // Integer division → number of trips by bus i
        }

        return sum;
    }
}
