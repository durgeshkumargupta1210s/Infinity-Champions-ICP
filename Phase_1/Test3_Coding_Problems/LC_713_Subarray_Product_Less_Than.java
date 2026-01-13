package Test3_Coding_Problems;

public class LC_713_Subarray_Product_Less_Than {

    public static void main(String[] args) {
        // Input array and target
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        // si = start index of sliding window
        int si = 0;
        // p = product of elements in current window
        int p = 1;
        // ans = count of subarrays with product < k
        int ans = 0;

        // Iterate over the array using end index ei
        for (int ei = 0; ei < nums.length; ei++) {
            p = p * nums[ei]; // multiply current element into the product

            // Shrink the window from the left while product >= k
            while (si <= ei && p >= k) {
                p = p / nums[si]; // divide out the leftmost element
                si++;             // move start index forward
            }

            // All subarrays ending at ei and starting from si to ei are valid
            // Number of such subarrays = (ei - si + 1)
            ans += (ei - si + 1);
        }

        // Print the total count of subarrays
        System.out.println(ans); // Expected output: 8
    }
}
