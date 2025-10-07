package Day3_ClassAssigment;
import java.util.*;
public class LC_1380_Lucky_Numbers_in_a_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{3,7,8},{9,11,13},{15,16,17}};
		 luckyNumbers(matrix);
		

	}
	public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;         // Number of rows
        int n = matrix[0].length;      // Number of columns
        List<Integer> list = new ArrayList<>();

        // Traverse each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];

                // Check if num is the minimum in its row AND maximum in its column
                if (isMinimumInRow(num, i, n, matrix) && isMaximumInColumn(num, j, m, matrix)) {
                    list.add(num);
                }
            }
        }

        return list;
    }

    // ✅ Checks if num is the minimum element in its row
    public static boolean isMinimumInRow(int num, int row, int cols, int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            min = Math.min(min, matrix[row][j]);
        }
        return min == num;
    }

    // ✅ Checks if num is the maximum element in its column
    public static boolean isMaximumInColumn(int num, int col, int rows, int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, matrix[i][col]);
        }
        return max == num;
    }

}
