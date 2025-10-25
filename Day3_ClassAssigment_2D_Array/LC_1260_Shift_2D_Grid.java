package Day3_ClassAssigment_2D_Array;

import java.util.*;

public class LC_1260_Shift_2D_Grid {

	public static void main(String[] args) {
		// Sample 3x3 grid
		int [][]grid = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int k = 1; // Number of shifts

		// Call the method to shift the grid
		List<List<Integer>> shifted = shiftGrid(grid, k);

		// Print the result
		for (List<Integer> row : shifted) {
			System.out.println(row);
		}
	}

	// Method to shift the 2D grid 'k' times
	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;       // Number of rows
        int n = grid[0].length;    // Number of columns
        int total = m * n;         // Total number of elements in the grid

        // No need to shift more than total elements,
        // because shifting 'total' times brings the grid back to its original state.
        k = k % total;

        // Create a new grid to store the shifted values
        int[][] newGrid = new int[m][n];

        // Traverse each element of the original grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Flatten the 2D position (i, j) to a 1D index
                int oldIndex = i * n + j;

                // Calculate the new 1D index after shifting by 'k'
                int newIndex = (oldIndex + k) % total;

                // Convert the new 1D index back to 2D coordinates (newRow, newCol)
                int newRow = newIndex / n;
                int newCol = newIndex % n;

                // Place the original element into its new shifted position
                newGrid[newRow][newCol] = grid[i][j];
            }
        }

        // Convert the shifted grid (2D array) into a List<List<Integer>> format
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(newGrid[i][j]);
            }
            result.add(row);
        }

        // Return the final shifted grid as a list of lists
        return result;
    }
}
