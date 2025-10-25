package Day5_HomeAssigment_Greedy;

import java.util.Arrays;

public class LC_881_Boats_to_Save_People {

	public static void main(String[] args) {
		// Input array: weights of people
		int []people = {3,2,2,1};
		// Boat limit: maximum weight each boat can carry
		int limit = 3;
		
		// Sort the people array so we can pair the lightest with the heaviest
		Arrays.sort(people);
		
		// Counters for how many boats are used
		int pairCount = 0;   // boats with 2 people
		int singleCount = 0; // boats with 1 person
		
		// Two-pointer approach
		int left = 0;                 // pointer to the lightest person
		int right = people.length-1;  // pointer to the heaviest person
		
		// Process until all people are placed in boats
		while(left <= right) {
			// If lightest + heaviest fit in one boat, take them together
			if(people[left] + people[right] <= limit) {
				pairCount++;   // one boat carries both
				left++;        // move to next lightest
				right--;       // move to next heaviest
			}
			// Otherwise, the heaviest person must go alone
			else {
				singleCount++; 
				right--; // move to next heaviest
			}
		}
		
		// Total boats used = boats with pairs + boats with singles
		System.out.println(singleCount + pairCount);

	}

}
