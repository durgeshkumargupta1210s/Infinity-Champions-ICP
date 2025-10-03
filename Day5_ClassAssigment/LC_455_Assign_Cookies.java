package Day5_ClassAssigment;
import java.util.*;
public class LC_455_Assign_Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []g = {1,2,3};
		int []s = {1,1};
		System.out.println(findContentChildren(g,s));

	}
	public static int findContentChildren(int[] g, int[] s) {
        // Sort greed factors of children (ascending order)
        // and cookie sizes (ascending order)
        Arrays.sort(g);
        Arrays.sort(s);

        // Start from the end (largest greed & largest cookie)
        int i = g.length - 1;  // pointer for children
        int j = s.length - 1;  // pointer for cookies
        int count = 0;         // number of satisfied children

        // Process until either children or cookies run out
        while (i >= 0 && j >= 0) {
            // If the largest available cookie can satisfy the current child
            if (s[j] >= g[i]) {
                count++;  // assign cookie
                i--;      // move to next child
                j--;      // move to next cookie
            } else {
                // If cookie is too small, skip this child
                // (maybe a smaller child can be satisfied later)
                i--;
            }
        }

        // Return total number of children who got cookies
        return count;
    }

}
