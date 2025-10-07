package Day6_HomeAssigment;
import java.util.*;
public class LC_40_Combination_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<Integer> ll=new ArrayList<>();
		List<List<Integer>>ans=new ArrayList<>();
		combinationSum(candidates,target,ll,ans,0);
        return ans;
    }
    private static void combinationSum(int[] candidates, int target, List<Integer> ll, List<List<Integer>> ans,int idx) {
		// TODO Auto-generated method stub
		if(target==0) {
			ans.add(new ArrayList(ll));
			return;
		}
		for(int i=idx; i<candidates.length; i++) {
			if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
			
			if(candidates[i]<=target) {
				ll.add(candidates[i]);
				combinationSum(candidates,target-candidates[i],ll,ans,i+1);
				ll.remove(ll.size()-1);
				
				
			}
		}	
	}

}
