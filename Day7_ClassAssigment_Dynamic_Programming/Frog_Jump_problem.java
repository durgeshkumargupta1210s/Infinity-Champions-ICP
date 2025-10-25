package Day7_ClassAssigment_Dynamic_Programming;

import java.util.Arrays;

public class Frog_Jump_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []heights = {7, 5, 1, 2, 6};
		int []dp=new int[heights.length];
		Arrays.fill(dp,-1);
		System.out.println(minimumEnergy(heights,0,dp));

	}

	private static int minimumEnergy(int[] heights, int i, int []dp) {
		// TODO Auto-generated method stub
		if(i==heights.length-1) return 0;
		
		if(i>heights.length-1) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int one=Integer.MAX_VALUE;
		if(i+1<heights.length) {
			one= Math.abs(heights[i]-heights[i+1])+minimumEnergy(heights,i+1,dp);
		}
		
		int two=Integer.MAX_VALUE;
		if(i+2<heights.length) {
			two= Math.abs(heights[i]-heights[i+2])+minimumEnergy(heights,i+2,dp);
		}
		
		return dp[i]=Math.min(one, two);
	 
	}

}
