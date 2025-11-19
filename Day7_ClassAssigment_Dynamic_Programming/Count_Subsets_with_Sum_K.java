package Day7_ClassAssigment_Dynamic_Programming;

public class Count_Subsets_with_Sum_K {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 16, 8, 10};
        int k = 10;

        System.out.println("🔹 Recursive Count: " + countSubsetRecursive(arr, k, 0));
        System.out.println("🔹 DP Count: " + countSubsetDP(arr, k));
    }

    // ==============================================================
    // 🧮 1️⃣ RECURSIVE APPROACH (Top-Down)
    // ==============================================================

    private static int countSubsetRecursive(int[] arr, int k, int idx) {

        // Base Case 1: If target sum becomes 0, we found a valid subset
        if (k == 0) {
            return 1;
        }

        // Base Case 2: If we reach the end of array without sum = 0
        if (idx == arr.length) {
            return 0;
        }

        // Recursive choice 1️⃣: Include current element if it doesn't exceed k
        int include = 0;
        if (arr[idx] <= k) {
            include = countSubsetRecursive(arr, k - arr[idx], idx + 1);
        }

        // Recursive choice 2️⃣: Exclude current element
        int exclude = countSubsetRecursive(arr, k, idx + 1);

        // Total count = include + exclude
        return include + exclude;
    }

    // ==============================================================
    // 🧠 2️⃣ DYNAMIC PROGRAMMING APPROACH (Bottom-Up)
    // ==============================================================

    private static int countSubsetDP(int[] arr, int k) {
        int n = arr.length;

        // dp[i][j] = number of subsets from first i elements with sum = j
        int[][] dp = new int[n][k + 1];

        // Base Case: Only one subset (empty set) gives sum 0
        for (int i = 0; i <n; i++) {
            dp[i][0] = 1;
        }
        
        if(arr[0]<=k) {
        	dp[0][arr[0]]=1;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                // Exclude current element
                int exclude = dp[i - 1][j];

                // Include current element if it doesn’t exceed target
                int include=0;
                if (arr[i] <= j) {
                    include+= dp[i-1][j - arr[i]];
                }
                
                dp[i][j]=include+exclude;
            }
        }

        // The answer will be the number of subsets from all n elements with sum = k
        return dp[n-1][k];
    }
}
