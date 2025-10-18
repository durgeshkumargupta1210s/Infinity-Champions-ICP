package Day3_HomeAssigment;

/**
 * LeetCode 240: Search a 2D Matrix II
 * ------------------------------------
 * Problem:
 * Given an m x n matrix where each row and column is sorted in ascending order,
 * return true if the target is found in the matrix, otherwise return false.
 * 
 * Approach:
 * - For each row, check if the target could lie within the row's range (first and last element).
 * - If yes, perform binary search on that row.
 * - If target found, return true; otherwise continue.
 * 
 * Time Complexity: O(m * log n)
 * Space Complexity: O(1)
 */
public class LC_240_Search_a_2D_Matrix_II {

    public static void main(String[] args) {
        // Sample input matrix (rows and columns sorted)
        int [][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        
        int target = 5;  // Element to search
        
        // Print whether the target is found or not
        System.out.println(searchMatrix(matrix, target));
    }

    /**
     * Searches for a target in a sorted 2D matrix.
     * 
     * @param matrix The input 2D matrix (each row and column sorted).
     * @param target The number to search for.
     * @return true if target is found, otherwise false.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;        // Number of rows
        int n = matrix[0].length;     // Number of columns
        boolean ans = false;         // To store search result

        // Iterate through each row
        for (int i = 0; i < m; i++) {

            // If the target lies between the first and last element of this row,
            // then only perform binary search in this row
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                ans = searchElement(matrix[i], target); // Binary search in row i
            }

            // If found, return true immediately
            if (ans) {
                return true;
            }
        }

        // Target not found in any row
        return false;
    }

    /**
     * Performs binary search in a sorted 1D array (row).
     * 
     * @param row    The row array to search in.
     * @param target The number to search for.
     * @return true if target is found, otherwise false.
     */
    public static boolean searchElement(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        // Standard binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] == target) {
                return true;            // Target found
            } else if (row[mid] > target) {
                high = mid - 1;         // Search in left half
            } else {
                low = mid + 1;          // Search in right half
            }
        }

        // Target not found in this row
        return false;
    }
}
