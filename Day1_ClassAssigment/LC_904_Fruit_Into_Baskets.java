package Day1_ClassAssigment;
import java.util.*;
public class LC_904_Fruit_Into_Baskets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []fruits = {1,2,3,2,2};
		
		// we need to maintain a window of 2 type of element
		// basically now it becomes the question like:-
		
		// find the longest size subarray having at most two distinct number
		
		HashMap<Integer,Integer> map=new HashMap<>();
		int si=0;
		int ans=Integer.MIN_VALUE;
		for(int ei=0; ei<fruits.length; ei++) {
			map.put(fruits[ei], map.getOrDefault(fruits[ei],0)+1);
			
			while(map.size()>2) {
				map.put(fruits[si], map.get(fruits[si])-1);
				if(map.get(fruits[si])==0) {
					map.remove(fruits[si]);
					si++;
				}
			}
			ans=Math.max(ans, ei-si+1);
		}
		System.out.println(ans);

	}

}
