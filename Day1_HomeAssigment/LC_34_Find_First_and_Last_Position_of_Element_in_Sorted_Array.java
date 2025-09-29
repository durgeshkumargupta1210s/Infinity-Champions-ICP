package Day1_HomeAssigment;

public class LC_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums = {5,7,7,8,8,10};
		int target = 8;
		int first=findFirstIdx(nums,target);
		int last=findSecondIdx(nums,target);
		
		System.out.println("First_index "+ first);
		System.out.println("Last_index "+ last);
	
	}

	private static int findSecondIdx(int[] nums, int target) {
		// TODO Auto-generated method stub
		int low=0;
		int high=nums.length-1;
		int first=-1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(nums[mid]==target) {
				first=mid;
				
				low=mid+1;
				
			}
			else if(nums[mid]>target) {
				high=mid-1;
			
			}
			else {
				low=mid+1;
			}
		}
		return first;
	}

	private static int findFirstIdx(int[] nums, int target) {
		int low=0;
		int high=nums.length-1;
		int last=-1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(nums[mid]==target) {
				last=mid;
				high=mid-1;
				
				
			}
			else if(nums[mid]>target) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return last;

	}

}
