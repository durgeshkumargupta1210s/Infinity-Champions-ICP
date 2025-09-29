package Day2_HomeAssigment;

import java.util.*;

public class LC_215_Kth_Largest_Element_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,2,1,5,6,4};
		int k = 2;
		
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : nums){
            pq.add(ele);
        }
        while(!pq.isEmpty()){
            int rv=pq.poll();
            k--;
            if(k==0){
                System.out.println(rv);
                break;
            }
        }
	}

}
