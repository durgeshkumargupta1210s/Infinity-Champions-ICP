package Day4_ClassAssigment;
import java.util.*;
public class LC_76_Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s,t));

	}
	public static String minWindow(String s, String t) {
        // If 's' is shorter than 't', it's impossible to find the substring
        if (s.length() < t.length()) return "";

        // Step 1: Store frequency of each character in 't' in a map
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // si: start index of sliding window
        // need: number of characters we still need to match from 't'
        // ans: length of minimum window found so far
        // sub_si: starting index of the minimum window substring
        int si = 0, need = t.length(), ans = Integer.MAX_VALUE, sub_si = 0;

        // Step 2: Expand the window by moving 'ei' (end index)
        for (int ei = 0; ei < s.length(); ei++) {
            char ch = s.charAt(ei);

            // If the character is needed (frequency > 0), reduce 'need'
            if (map.containsKey(ch) && map.get(ch) > 0) {
                need--;
            }

            // Decrease the frequency for this character (even if it's not in 't')
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // Step 3: When 'need' reaches 0, we have a valid window
            while (need == 0) {
                char ch1 = s.charAt(si);

                // Update answer if current window is smaller than previous best
                if (ans > ei - si + 1) {
                    ans = ei - si + 1;
                    sub_si = si;
                }

                // Shrink the window from the left and restore frequency
                map.put(ch1, map.getOrDefault(ch1, 0) + 1);

                // If after restoring, frequency becomes > 0, it means we're now missing this character
                if (map.get(ch1) > 0) {
                    need++;
                }

                si++;  // Move start index forward
            }
        }

        // Step 4: Return the smallest valid window substring if found, else return empty string
        return ans == Integer.MAX_VALUE ? "" : s.substring(sub_si, sub_si + ans);
    }

}
