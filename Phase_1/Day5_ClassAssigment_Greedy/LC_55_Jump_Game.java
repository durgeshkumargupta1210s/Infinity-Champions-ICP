package Day5_ClassAssigment_Greedy;

public class LC_55_Jump_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {2,3,1,1,4};
		System.out.println(canJump(nums));
		

	}
	
	    public static boolean canJump(int[] nums) {
	        // maxReach stores the farthest index we can reach so far
	        int maxReach = 0;

	        // Iterate over each index of the array
	        for (int i = 0; i < nums.length; i++) {
	            
	            // If the current index is greater than the farthest reachable index,
	            // it means we cannot even reach this index → return false
	            if (i > maxReach) {
	                return false;
	            }

	            // Update the farthest reachable index from current position
	            maxReach = Math.max(maxReach, i + nums[i]);

	            // If we can reach or go beyond the last index, return true
	            if (maxReach >= nums.length - 1) {
	                return true;
	            }
	        }

	        // If loop completes without any issues, we can reach the end
	        return true;
	    }
	}



/*
-------------------------
Dry Run Example: nums = [2, 3, 1, 1, 4]
-------------------------
Initially: maxReach = 0

i = 0 → nums[0] = 2
   - i (0) <= maxReach (0) ✅
   - maxReach = max(0, 0+2) = 2
   - Can reach indices [0..2] now.

i = 1 → nums[1] = 3
   - i (1) <= maxReach (2) ✅
   - maxReach = max(2, 1+3) = 4
   - Now we can reach index 4 (last index).

Since maxReach (4) >= nums.length-1 (4),
we can reach the last index → return true.

-------------------------
Dry Run Example: nums = [3, 2, 1, 0, 4]
-------------------------
Initially: maxReach = 0

i = 0 → nums[0] = 3
   - i (0) <= maxReach (0) ✅
   - maxReach = max(0, 0+3) = 3
   - Can reach indices [0..3].

i = 1 → nums[1] = 2
   - i (1) <= maxReach (3) ✅
   - maxReach = max(3, 1+2) = 3

i = 2 → nums[2] = 1
   - i (2) <= maxReach (3) ✅
   - maxReach = max(3, 2+1) = 3

i = 3 → nums[3] = 0
   - i (3) <= maxReach (3) ✅
   - maxReach = max(3, 3+0) = 3

i = 4 → nums[4] = 4
   - i (4) > maxReach (3) ❌
   - Cannot reach index 4 → return false.

*/

