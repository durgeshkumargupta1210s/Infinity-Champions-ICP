package Day5_HomeAssigment_Greedy;
import java.util.*;
public class LC_406_Queue_Reconstruction_by_Height {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(people);

	}
	public static int[][] reconstructQueue(int[][] people) {

        // Step 1: Sort the people array
        // - First, sort by height in descending order (taller people first)
        // - If heights are equal, sort by k in ascending order (smaller k first)
        //   This ensures that taller people are placed first, and for same height,
        //   the person with fewer people in front comes first
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) 
                return Integer.compare(a[1], b[1]); // smaller k first if same height
            return Integer.compare(b[0], a[0]);     // taller first
        });

        // Step 2: Use a list to reconstruct the queue
        List<int[]> list = new ArrayList<>();

        // Step 3: Insert each person into the list at index = k
        // - Because k indicates how many people should be in front of this person
        // - Since taller people are already placed, inserting at index k ensures the k constraint
        for (int[] arr : people) {
            int height = arr[0]; // person's height (not strictly needed here, just for clarity)
            int k = arr[1];        // number of people taller-or-equal in front
            list.add(k, arr);    // insert person at position k
        }

        // Step 4: Convert the list back to a 2D array and return
        return list.toArray(new int[people.length][2]);
    }

}
