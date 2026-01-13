package Day5_ClassAssigment_Greedy;
import java.util.*;

public class GFG_Activity_Selection {

	public static void main(String[] args) {
		// Start and finish time arrays
		int start[] = {1, 3, 0, 5, 8, 5};
		int finish[] = {2, 4, 6, 7, 9, 9};

		// Call the function and print maximum number of activities
		System.out.println(activitySelection(start, finish));
	}

	public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;

        // Step 1: Combine start and finish times for each activity into a single array
        // arr[i][0] = start time, arr[i][1] = finish time
        int [][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }

        // Step 2: Sort activities based on their finish time in ascending order
        // Reason: By selecting activities that finish earliest, we leave the most room
        // for future activities → greedy choice
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 3: Always select the first activity after sorting
        // because it has the earliest finishing time
        int count = 1;             // at least one activity can be selected
        int prevEnd = arr[0][1];   // end time of the last selected activity

        // Step 4: Traverse remaining activities
        for (int i = 1; i < n; i++) {
            int currStart = arr[i][0];
            int currEnd = arr[i][1];

            // Step 4.1: Check if the current activity can be selected
            // Condition: its start time should be strictly greater than
            // the finish time of the previously selected activity
            if (currStart > prevEnd) {
                count++;            // select this activity
                prevEnd = currEnd;  // update the end time for comparison with future activities
            }
        }

        // Step 5: Return the total number of activities selected
        return count;
    }
}
