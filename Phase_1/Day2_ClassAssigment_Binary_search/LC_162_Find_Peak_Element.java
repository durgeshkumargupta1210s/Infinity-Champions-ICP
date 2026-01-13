package Day2_ClassAssigment_Binary_search;

public class LC_162_Find_Peak_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,3,1};
		int n=nums.length;
		
		// if 0th idx num > 1st idx num then 0th idx is peak element 
		if(n==1 || nums[0]>nums[1]) {
			System.out.println(0);
		}
		
		// if last ele is greater than second last ele then last element is our peak
		
		if(nums[n-1]>nums[n-2]) {
			System.out.println(n-1);
		}
		
		// predicative approach --> binarySearch	
		int low=1;
		int high=nums.length-2;
		
		while(low<=high) {
			int mid=(low+high)/2;
			
			if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) {
				System.out.println(mid);
				break;
			}
			else if(nums[mid]>nums[mid+1]) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
			
		}

	}

}
