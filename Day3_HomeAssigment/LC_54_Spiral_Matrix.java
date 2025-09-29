package Day3_HomeAssigment;

import java.util.*;

public class LC_54_Spiral_Matrix {

	private static List<Integer> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		list=spiralOrder(matrix);

	}
	public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;

        int left=0;
        int right=n-1;
        int top=0;
        int buttom=m-1;

        while(top<=buttom && left<=right){
            // right
            for(int i=left; i<=right; i++){
                list.add(matrix[top][i]);
            };
            top++;

            //

            for(int i=top; i<=buttom; i++){
                list.add(matrix[i][right]);
            };
            right--;

            if(top<=buttom){
                for(int i=right; i>=left; i--){
                    list.add(matrix[buttom][i]);
                }
            }
            buttom--;

            if(left<=right){
               for(int i=buttom; i>=top; i--){
                    list.add(matrix[i][left]);
                } 
            }
            left++;
        }

        return list;



        
    }

}
