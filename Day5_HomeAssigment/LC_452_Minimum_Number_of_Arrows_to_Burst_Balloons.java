package Day5_HomeAssigment;

import java.util.Arrays;

public class LC_452_Minimum_Number_of_Arrows_to_Burst_Balloons {

	public static void main(String[] args) {
		// Example test cases
		// int [][]points = {{10,16},{2,8},{1,6},{7,12}};
		int [][]points= {{1,2},{3,4},{5,6},{7,8}};
		
		// Step 1: Sort intervals (balloons) by starting point, 
		// and if equal, then by ending point
		Arrays.sort(points,(a,b)->{
			if(a[0]==b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			else {
				return Integer.compare(a[0], b[0]);
			}
		});
		
		// Step 2: Take the first balloon interval as reference
		int [] prev=points[0];
		
		// At least one arrow is needed initially
		int count=1;
		
		// Step 3: Traverse through all balloon intervals
		for(int i=1; i<points.length; i++) {
			 
			// If the current balloon starts after the previous interval ends
			// → No overlap, so we need a new arrow
			if(points[i][0]>prev[1]) {
				count++;           // Increase arrow count
				prev=points[i];    // Update previous interval
			}
			else{
				// Otherwise, there is an overlap.
				// We shrink the overlapping interval to maximize common area.
				prev[0]=Math.max(prev[0], points[i][0]); // Update start of overlap
				prev[1]=Math.min(prev[1], points[i][1]); // Update end of overlap
			}
		}
		
		// Step 4: Print result → minimum arrows needed
		System.out.println(count);
	}
}
