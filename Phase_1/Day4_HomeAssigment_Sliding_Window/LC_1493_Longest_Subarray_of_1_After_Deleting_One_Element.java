package Day4_HomeAssigment_Sliding_Window;

public class LC_1493_Longest_Subarray_of_1_After_Deleting_One_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,1,0,1};
		System.out.println(longestSubarray(nums));

	}
	public static int longestSubarray(int[] nums) {

        int count=0;
        int si=0;
        int ans=0;

        for(int ei=0; ei<nums.length; ei++){
            if(nums[ei]==0){
                count++;
            }

            if(count>1){
                if(nums[si]==0){
                    count--;
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
        }
        return ans-1;
        
    }

}
