package Day6_ClassAssigment_Recursion;

import java.util.Arrays;

public class LC_344_Reverse_String {

    public static void main(String[] args) {
        // Declare and initialize a character array (the string to be reversed)
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Call the reverseString method to reverse the array in place
        reverseString(s);

        // Print the reversed array to verify the output
        System.out.println(Arrays.toString(s));
    }

    /**
     * Reverses the character array using a recursive helper method.
     * @param s The character array to reverse.
     */
    public static void reverseString(char[] s) {
        int left = 0;                // Starting index (left pointer)
        int right = s.length - 1;    // Ending index (right pointer)

        // Call the recursive helper function to reverse the array
        reverse(s, left, right);
    }

    /**
     * Recursive helper function to reverse the array in place.
     * Swaps the characters at the 'left' and 'right' indices, 
     * then recursively moves towards the center.
     *
     * @param s The character array to reverse.
     * @param left Current left index.
     * @param right Current right index.
     */
    public static void reverse(char[] s, int left, int right) {
        // Base condition: stop recursion when left crosses right
        if (left > right) {
            return;
        }

        // Swap characters at positions 'left' and 'right'
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Move the pointers inward and continue recursion
        reverse(s, left + 1, right - 1);
    }
}
