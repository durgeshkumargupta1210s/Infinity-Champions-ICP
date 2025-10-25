package Day7_ClassAssigment_Dynamic_Programming;
import java.util.*;
public class LC_63_Unique_Path_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));

	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;        // number of rows
        int n = obstacleGrid[0].length;     // number of columns

        // DP array to store computed results and avoid recomputation
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize dp with -1 to indicate uncomputed states
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Start from (0, 0) → top-left corner
        return countPath(0, 0, obstacleGrid, dp);
    }

    // Recursive function to count paths from (cr, cc) to destination
    public static int countPath(int cr, int cc, int[][] og, int[][] dp) {

        // Base Case 1: Out of bounds OR cell has obstacle → no path
        if (cr >= og.length || cc >= og[0].length || og[cr][cc] == 1) {
            return 0;
        }

        // Base Case 2: Reached destination → one valid path found
        if (cr == og.length - 1 && cc == og[0].length - 1) {
            return 1;
        }

        // If already computed, return the stored result
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        // Move Down and Right recursively
        int down = countPath(cr + 1, cc, og, dp);   // go down
        int right = countPath(cr, cc + 1, og, dp);  // go right

        // Store and return total paths from current cell
        return dp[cr][cc] = down + right;
    }

}
