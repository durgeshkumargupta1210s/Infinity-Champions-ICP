package Day3_HomeAssigment_2D_Array;

public class LC_74_Search_a_2D_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
		int target = 3;
		System.out.println(searchMatrix(matrix,target));
		

	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=(m*n-1);

        while(low<=high){
            int mid=(low+high)/2;

            int row=mid/n;
            int col=mid%n;

            if(matrix[row][col]==target){
                return true;
            }

            else if(matrix[row][col]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
        
    }

}
