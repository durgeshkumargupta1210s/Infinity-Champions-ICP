package Day2_ClassAssigment_Binary_search;

public class LC_704_Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-1,0,3,5,9,12};
		int target = 9;
		
		int left=0;
		int right=nums.length-1;
		
		while(left<right) {
			int mid=(left+right)/2;
			if(nums[mid]==target) {
				System.out.println(mid);
				break;
			}
			else if(nums[mid]>target) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}

	}

}
