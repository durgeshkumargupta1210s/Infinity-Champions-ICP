package Day4_HomeAssigment_Sliding_Window;
import java.util.*;
public class LC_424_Longest_Repeating_Character_Replacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABAB";
		int k = 2;
		System.out.println(characterReplacement(s,k));

	}
	    public static int characterReplacement(String s, int k) {
	        int si = 0;           // Start index of the sliding window
	        int ei = 0;           // End index of the sliding window
	        int maxLen = 0;       // Stores the length of the longest valid substring
	        int maxCount = 0;     // Stores the count of the most frequent character in the current window
	        HashMap<Character, Integer> map = new HashMap<>();  // Frequency map for characters in the window

	        // Step 1: Expand the window by moving 'ei'
	        for (ei = 0; ei < s.length(); ei++) {
	            char ch = s.charAt(ei);

	            // Increase the frequency of the current character
	            map.put(ch, map.getOrDefault(ch, 0) + 1);

	            // Update maxCount to keep track of the character with the highest frequency in the current window
	            maxCount = Math.max(maxCount, map.get(ch));

	            // Step 2: Check if the current window is valid
	            // (ei - si + 1) = total length of current window
	            // maxCount = count of most frequent character in this window
	            // If replacements needed > k, shrink from the left
	            while ((ei - si + 1) - maxCount > k) {
	                char c = s.charAt(si);

	                // Decrease the frequency of the character going out of the window
	                map.put(c, map.get(c) - 1);

	                // Remove from map if its frequency becomes 0 (optional but clean)
	                if (map.get(c) == 0) {
	                    map.remove(c);
	                }

	                si++; // Shrink the window from the left
	            }

	            // Step 3: Update maxLen with the size of the current valid window
	            maxLen = Math.max(maxLen, ei - si + 1);
	        }

	        // Step 4: Return the length of the longest valid substring found
	        return maxLen;
	    }
	}
