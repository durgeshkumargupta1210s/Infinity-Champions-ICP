package Test3_Coding_Problems;

public class LC_26_Remove_Duplicates_from_Sorted_Array {

    public static void main(String[] args) {
        // Example input: sorted array with duplicates
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // 'c' is the index of the last unique element found
        int c = 0;

        // Start from the second element and iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // If current element is different from the last unique element
            if (nums[i] != nums[c]) {
                c++;              // Move the unique index forward
                nums[c] = nums[i]; // Place the new unique element at position 'c'
            }
        }

        // The number of unique elements is 'c + 1'
        System.out.println(c + 1);

        // Optional: print the array with unique elements at the start
         for (int i = 0; i <= c; i++) {
             System.out.print(nums[i] + " ");
         }
    }
}
