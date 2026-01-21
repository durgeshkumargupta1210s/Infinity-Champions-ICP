package week_1;

import java.util.Scanner;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		int n=sc.nextInt();
		int[] prices=new int[n];
//		int []prices = {7,1,5,3,6,4};
		
		// brute-force
		int ans=Integer.MIN_VALUE;
		for(int i=0; i<prices.length; i++) {
			for(int j=i+1; j<prices.length; j++) {
				ans=Math.max(ans,prices[j]-prices[i]);
			}
		}
		System.out.println(ans);
		
		// optiml 
		int min=prices[0];
		
		for(int i=0; i<prices.length; i++) {
			if(min>prices[i]) {
				min=prices[i];
			}
			ans=Math.max(ans, prices[i]-min);
		}
		System.out.println(ans);
	}

	}
