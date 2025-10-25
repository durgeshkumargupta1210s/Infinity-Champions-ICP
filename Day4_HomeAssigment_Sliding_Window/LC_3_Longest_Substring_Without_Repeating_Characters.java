package Day4_HomeAssigment_Sliding_Window;
import java.util.*;

public class LC_3_Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        // Example input
        String s = "abcabcbb";

        // Call the function and print the length of longest substring without repeating characters
        System.out.println(lengthOfLongestSubstring(s));
    }

    // Function to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // stores frequency of characters in current window
        int ans = 0;  // stores maximum length found so far
        int si = 0;   // start index of the sliding window

        // Iterate over the string with end index ei
        for (int ei = 0; ei < s.length(); ei++) {
            char ch = s.charAt(ei);

            // Add current character to the map or increment its frequency
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If the current character occurs more than once, shrink window from the left
            while (map.get(ch) > 1) {
                char startChar = s.charAt(si);         // character at start of window
                map.put(startChar, map.get(startChar) - 1); // decrement its frequency

                // Remove the character from map if its frequency becomes 0
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }

                si++; // move start of window forward
            }

            // Update maximum length of substring without repeating characters
            ans = Math.max(ans, ei - si + 1);
        }

        return ans; // return the maximum length
    }
}
