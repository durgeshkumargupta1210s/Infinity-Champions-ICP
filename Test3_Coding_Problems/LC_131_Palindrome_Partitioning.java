package Test3_Coding_Problems;

import java.util.*;

public class LC_131_Palindrome_Partitioning {

    // Static list to store all possible palindrome partitions
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        // Input string
        String s = "aab";

        // Temporary list to store the current partition during recursion
        List<String> temp = new ArrayList<>();

        // Start recursive palindrome partitioning
        palindromePartition(s, temp);

        // Print all possible palindrome partitions
        System.out.println(result);
    }

    /**
     * Recursive function to generate all palindrome partitions of a string
     * 
     * @param question Remaining string to partition
     * @param temp     Current list of palindromic substrings
     */
    private static void palindromePartition(String question, List<String> temp) {

        // Base case: if no characters are left, add the current partition to result
        if (question.length() == 0) {
            result.add(new ArrayList<>(temp)); // Make a copy of temp
            return;
        }

        // Try all possible prefixes of the current string
        for (int i = 1; i <= question.length(); i++) {
            // Take the first i characters as a substring
            String str = question.substring(0, i);

            // If the substring is a palindrome, proceed recursively
            if (isPalindrome(str)) {
                // Add substring to current partition
                temp.add(str);

                // Recursively partition the remaining string
                palindromePartition(question.substring(i), temp);

                // Backtrack: remove the last added substring to try next possibility
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * Function to check if a string is a palindrome
     * 
     * @param str Input string
     * @return true if str is palindrome, false otherwise
     */
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;   // Move left pointer forward
            right--;  // Move right pointer backward
        }

        // All characters matched, it is a palindrome
        return true;
    }
}
