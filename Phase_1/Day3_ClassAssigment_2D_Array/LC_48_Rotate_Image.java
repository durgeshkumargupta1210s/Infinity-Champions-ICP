package Day3_ClassAssigment_2D_Array;

import java.util.Arrays;

public class LC_48_Rotate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		System.out.println(Arrays.deepToString(rotate(matrix)));

	}
	public static void rotate(int[][] matrix) {
        int n=matrix.length;

        // step1 : Transpose of the Matrix
        for(int i=0; i<n ; i++){
            for(int j=i+1; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }

}
