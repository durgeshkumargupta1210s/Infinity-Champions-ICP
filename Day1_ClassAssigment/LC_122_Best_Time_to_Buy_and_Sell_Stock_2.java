package Day1_ClassAssigment;

public class LC_122_Best_Time_to_Buy_and_Sell_Stock_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []prices = {7,1,5,3,6,4};
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // If today's price is higher than yesterday's, take the profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        System.out.println(profit);

	}

}
