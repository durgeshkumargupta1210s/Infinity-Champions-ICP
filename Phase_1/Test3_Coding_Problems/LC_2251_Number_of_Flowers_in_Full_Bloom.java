package Test3_Coding_Problems;

import java.util.Arrays;

public class LC_2251_Number_of_Flowers_in_Full_Bloom {

    public static void main(String[] args) {
        // Example input
        int[][] flowers = {{1,6}, {3,7}, {9,12}, {4,13}};
        int[] people = {2,3,7,11};

        // Call the function and print result
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people))); // Expected: [1,2,2,2]
    }

    /**
     * Main function to find the number of flowers in full bloom for each person's arrival
     */
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;

        // Arrays to store start and end times separately
        int[] start = new int[n];
        int[] end = new int[n];

        // Result array for each person
        int[] ans = new int[people.length];

        // Step 1: Fill start and end arrays
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0]; // bloom start time
            end[i] = flowers[i][1];   // bloom end time
        }

        // Step 2: Sort start and end arrays for binary search
        Arrays.sort(start);  // ascending order of start times
        Arrays.sort(end);    // ascending order of end times

        // Step 3: Process each person's arrival time
        for (int i = 0; i < people.length; i++) {
            int time = people[i];

            // Number of flowers that have started blooming by 'time'
            int flowerStart = upperBound(start, time);

            // Number of flowers that ended BEFORE 'time'
            // (time-1 because flower ending at 'time' is still blooming)
            int flowerEnd = upperBound(end, time - 1);

            // Flowers in full bloom = started - ended
            ans[i] = flowerStart - flowerEnd;
        }

        return ans; // return the final result
    }

    /**
     * Custom upperBound function using Arrays.binarySearch
     * Finds the first index where element > target
     * Essentially returns count of elements ≤ target
     */
    public static int upperBound(int[] arr, int target) {
        // Arrays.binarySearch returns:
        // - index >= 0 if exact element found (any occurrence)
        // - -(insertion_point + 1) if not found
        int idx = Arrays.binarySearch(arr, target);

        if (idx >= 0) {
            // If key exists, move forward to find first element > target
            // Handles duplicate values
            while (idx < arr.length && arr[idx] <= target) {
                idx++;
            }
        } else {
            // Key not found
            // insertion point = -(idx + 1)
            idx = -(idx + 1);
        }

        // idx now represents:
        // - number of elements in arr that are ≤ target
        return idx;
    }
}
