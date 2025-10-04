package Day6_ClassAssigment;
import java.util.*;

public class LC_78_Subsets {
    // ✅ Make result static so it can be accessed in static methods
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        result.clear(); // clear previous results (important if running multiple times)
        List<Integer> current = new ArrayList<>();
        computeSubsets(nums, 0, current);
        return result;
    }

    public static void computeSubsets(int[] nums, int idx, List<Integer> current) {
        // Base case: when we've processed all elements
        if (idx == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // ✅ Include the current element
        current.add(nums[idx]);
        computeSubsets(nums, idx + 1, current);

        // ✅ Exclude the current element (backtrack)
        current.remove(current.size() - 1);
        computeSubsets(nums, idx + 1, current);
    }
}
