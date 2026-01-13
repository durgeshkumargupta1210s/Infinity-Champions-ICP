package Day3_HomeAssigment_2D_Array;

public class LC_59_Spiral_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		int[][] matrix = generateMatrix(n);
		
		

	}
	
	public static int[][] generateMatrix(int n) {
        int left=0;
        int right=n-1;
        int top=0;
        int buttom=n-1;
        int [][] matrix=new int[n][n];
        int digit=1;

        while(top<=buttom && left<=right){
            
            for(int i=left; i<=right; i++){
                matrix[top][i]=digit++;
            }
            top++;

            for(int i=top; i<=buttom; i++){
               matrix[i][right]=digit++; 
            }
            right--;

            if(top<=buttom){
                for(int i=right; i>=left; i--){
                    matrix[buttom][i]=digit++;
                }
            }
            buttom--;

            if(left<=right){
                for(int i=buttom; i>=top; i--){
                    matrix[i][left]=digit++;
                }
            }
            left++;
        }
        return matrix;
        
    }

}
