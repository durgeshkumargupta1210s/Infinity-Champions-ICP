package Day1_ClassAssigment;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []prices = {7,1,5,3,6,4};
		
		int n=prices.length;
        int ans=Integer.MIN_VALUE;
        int min=prices[0];

        for(int i=0; i<n; i++){
            if(min>prices[i]){
                min=prices[i];
            }

            ans=Math.max(ans,prices[i]-min);
        }

        System.out.println(ans);

	}

}
