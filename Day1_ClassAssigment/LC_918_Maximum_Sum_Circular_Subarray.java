package Day1_ClassAssigment;

public class LC_918_Maximum_Sum_Circular_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {5,-3,5};
		// kadans maximum subarray sum
		int MaximumSum=maximumSubArraySum(nums);
		// total element sum
		int totalSum=elementSum(nums);
		// kadans minimum subarray sum
		int MiniumSum=miniumSubArraySum(nums); 
		
		// circular sum
		int CircularSum=totalSum-MiniumSum;
		
		if(MaximumSum<0) {
			System.out.println(MaximumSum);
		}
		else {
			System.out.println(Math.max(MaximumSum,CircularSum ));
		}
		

	}

	private static int miniumSubArraySum(int[] nums) {
		// TODO Auto-generated method stub
		int ans=Integer.MAX_VALUE;
		int sum=0;
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			ans=Math.min(ans, sum);
			if(sum>0) {
				sum=0;
			}
			
		}
		return ans;
	}

	private static int elementSum(int[] nums) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int ele : nums) {
			sum+=ele;
		}
		return sum;
	}

	private static int maximumSubArraySum(int[] nums) {
		// TODO Auto-generated method stub
		int ans=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			ans=Math.max(ans, sum);
			if(sum<0) {
				sum=0;
			}
			
		}
		return ans;
	}

}
