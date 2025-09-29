package Day2_ClassAssigment;

public class LC_33_Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,5,6,7,0,1,2};
		int target = 0;
		
		int low=0;
		int high=nums.length-1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			
			if(nums[mid]==target) {
				System.out.println(mid);
				break;
			}
			
			
			// if left part is sorted
			if(nums[mid]>=nums[low]) {
				if(nums[low]<=target && nums[high]>=target) {
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			
			// if right part is sorted
						if(nums[high]>=nums[mid]) {
							if(nums[mid]<=target && nums[high]>=target) {
								low=mid+1;
							}
							else {
								high=mid-1;
							}
						}
		}
		

	}

}
