package Day6_HomeAssigment;
import java.util.*;
public class LC_77_Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> combine(int n, int k) {
        List<Integer> ll=new ArrayList<>();
		List<List<Integer>>ans=new ArrayList<>();
		combination(n,k,ll,ans,1);
       return  ans;
    }
    private static void combination(int n, int k, List<Integer> ll, List<List<Integer>> ans, int idx) {
		// TODO Auto-generated method stub
		if(ll.size()==k) {
			ans.add(new ArrayList(ll));
			return;
		}
		for(int i=idx; i<=n; i++) {
			if(ll.size()<k) {
				ll.add(i);
				combination(n,k,ll,ans,i+1);
				ll.remove(ll.size()-1);
			}
		}
	}

}
