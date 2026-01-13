package Test3_Coding_Problems;

public class LC_1219_Path_with_Maximum_Gold {

	public static void main(String[] args) {
		// Example grid
		int [][]grid = {
			{0, 6, 0},
			{5, 8, 7},
			{0, 9, 0}
		};

		// Call the function and print the maximum gold that can be collected
		System.out.println(getMaximumGold(grid));
	}

	/**
	 * This method finds the maximum amount of gold that can be collected
	 * by starting from any gold cell in the grid.
	 * We try starting from each non-zero cell and run DFS to get the maximum path.
	 */
	public static int getMaximumGold(int[][] grid) {
		int total = 0;

		// Traverse the entire grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// If the cell has gold, try collecting maximum gold starting from here
				if (grid[i][j] != 0) {
					int gold = CalculateMaximumGold(grid, i, j);
					total = Math.max(total, gold);  // update global maximum
				}
			}
		}
		return total;
	}

	/**
	 * DFS helper function to calculate maximum gold collectable from a cell.
	 * @param grid The gold grid.
	 * @param cr Current row.
	 * @param cc Current column.
	 * @return Maximum gold collectable starting from (cr, cc).
	 */
	public static int CalculateMaximumGold(int[][] grid, int cr, int cc) {
		// Base case: if out of bounds or cell is 0 (already visited or empty)
		if (cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length || grid[cr][cc] == 0) {
			return 0;
		}

		// Store current cell's gold and mark it visited by setting it to 0
		int temp = grid[cr][cc];
		grid[cr][cc] = 0;

		// Explore all 4 directions from the current cell
		int left = CalculateMaximumGold(grid, cr, cc - 1);
		int right = CalculateMaximumGold(grid, cr, cc + 1);
		int up = CalculateMaximumGold(grid, cr - 1, cc);
		int down = CalculateMaximumGold(grid, cr + 1, cc);

		// Backtrack: restore the cell's original gold value
		grid[cr][cc] = temp;

		// Return the gold collected from this cell + the maximum of all 4 directions
		return temp + Math.max(Math.max(left, right), Math.max(up, down));
	}
}
