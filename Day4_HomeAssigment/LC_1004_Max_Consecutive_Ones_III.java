package Day4_HomeAssigment;

public class LC_1004_Max_Consecutive_Ones_III {

    public static void main(String[] args) {
        // Example input
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        // Call the function and print the result
        System.out.println(longestOnes(nums, k));
    }

    // Function to find the maximum length of a subarray containing only 1s
    // after flipping at most k zeros to ones
    public static int longestOnes(int[] nums, int k) {

        int count = 0;   // number of zeros in the current window
        int si = 0;      // start index of the sliding window
        int ans = 0;     // maximum length found so far

        // Iterate through the array with the end index ei
        for (int ei = 0; ei < nums.length; ei++) {

            // If current element is 0, increase the zero count
            if (nums[ei] == 0) {
                count++;
            }

            // If zeros exceed k, shrink the window from the left
            if (count > k) {
                // If the element leaving the window is 0, decrease zero count
                if (nums[si] == 0) {
                    count--;
                }
                si++; // move the start index forward
            }
  
            // Update the maximum window length
            ans = Math.max(ans, ei - si + 1);
        }

        return ans; // return the maximum length of consecutive ones
    }
}
