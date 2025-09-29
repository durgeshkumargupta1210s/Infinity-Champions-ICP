package Day2_ClassAssigment;

public class LC_875_Koko_Eating_Bananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] piles = {3,6,7,11}; 
		int  h = 8;
		
		int low=1;
		int high=Maximum(piles);
		int ans=0;
		
		while(low<=high) {
			int mid=(low+high)/2;
			int totalTimeTaken=CalculateTime(piles,mid);
			
			if(totalTimeTaken<=h) {
				ans=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		System.out.println(ans);
		
		
				

	}

	private static int CalculateTime(int[] piles, int mid) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0; i<piles.length; i++) {
			sum+=(int)Math.ceil((double)piles[i]/mid);
		}
		return sum;
	}

	private static int Maximum(int[] piles) {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE;
		for(int i=0; i<piles.length; i++) {
			max=Math.max(max, piles[i]);
		}
		return max;
	}

}
