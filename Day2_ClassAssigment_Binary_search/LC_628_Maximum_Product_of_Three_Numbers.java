package Day2_ClassAssigment_Binary_search;

import java.util.Arrays;

public class LC_628_Maximum_Product_of_Three_Numbers {
	
	public static void main(String[] args) {
		int []nums = {1,2,3};
		int n=nums.length;
		
		Arrays.sort(nums);
		
		// if all +ve and weitage of -ve is less than the positive
		int product=nums[n-1]*nums[n-2]*nums[n-3];
		
		// if first two elements are -ve with high weitage and last element has +ve high weitage
		int produc1=nums[0]*nums[1]*nums[n-1];
		
		System.out.println(Math.max(product, produc1));
		
		
	
	}

}
