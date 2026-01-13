package Day1_HomeAssigment_Array;

import java.util.Arrays;

public class LC_452_Minimum_Number_of_Arrows_to_Burst_Balloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]points = {{10,16},{2,8},{1,6},{7,12}};
		Arrays.sort(points, (a, b) -> {
		    if (a[0] == b[0]) {
		        return Integer.compare(a[1], b[1]);
		    } else {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		
		int [] prev=points[0];
		int count=1;
		
		for(int i=1; i<points.length; i++) {
			int currentStart=points[i][0];
			int currentEnd=points[i][1];
			int prevStart=prev[0];
			int prevEnd=prev[1];
			
			// No overLapping
			if(prevEnd<currentStart) {
				count++;
				prev=points[i];
				
			}
			// overlapping ---> find how many comes under this overlap
			else {
				prev[0]=Math.max(prevStart, currentStart);// start of interval
				prev[1]=Math.min(prevEnd, currentEnd);// end of interval
			}
			
		}
		System.out.println(count); 

	}

}
