package Day5_HomeAssigment_Greedy;
import java.util.*;
public class LC_435_Non_overlapping_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]intervals = {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));

	}
	public static int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;

        if (n == 0) return 0;

        // Sort by start time, if equal then by end
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int[] prev = arr[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            int currStart = arr[i][0];
            int currEnd = arr[i][1];
            int prevEnd = prev[1];

            if (currStart < prevEnd) {
                // Overlap → remove one interval
                count++;
                // Keep the one with smaller end (greedy choice)
                if (currEnd < prevEnd) {
                    prev = arr[i];
                }
            } else {
                // No overlap → move forward
                prev = arr[i];
            }
        }
        return count;
    }

}
