package Day1_ClassAssigment_Array;
import java.util.*;
public class LC_15_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums = {-1,0,1,2,-1,-4};
		int n=nums.length;
		
		Set<List<Integer>> result=new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			Set<Integer> set=new HashSet<>();
			for(int j=i+1; j<n; j++) {
				int target=-(nums[i]+nums[j]);
				if(set.contains(target)) {
					List<Integer>triplet=new ArrayList<>(Arrays.asList(nums[i],nums[j],target));
					Collections.sort(triplet);
					result.add(triplet);
				}
				set.add(nums[j]);
			}
		}
		System.out.println(result);
	}

}
