package Day4_HomeAssigment_Sliding_Window;
import java.util.*;
public class LC_567_Permutation_in_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "eidbaooo";
		
		System.out.println(checkInclusion(s1,s2));

	}
	
	public static boolean checkInclusion(String s1, String s2) {
        int k = s1.length();

        // if s1 is longer than s2, impossible to find permutation
        if (s2.length() < k) return false;

        // frequency map of characters in s1
        Map<Character,Integer> mapOfS1 = new HashMap<>();

        // frequency map of current sliding window in s2
        Map<Character,Integer> mapOfS2Window = new HashMap<>();

        // build frequency of s1
        for (char ch : s1.toCharArray()) {
            mapOfS1.put(ch, mapOfS1.getOrDefault(ch, 0) + 1);
        }

        // build frequency for the first window of length k in s2
        for (int i = 0; i < k; i++) {
            char ch = s2.charAt(i);
            mapOfS2Window.put(ch, mapOfS2Window.getOrDefault(ch, 0) + 1);
        }

        // if the first window matches s1, return true
        if (mapOfS1.equals(mapOfS2Window)) return true;

        int si = 0; // start index of the sliding window

        // slide the window through the rest of s2
        for (int ei = k; ei < s2.length(); ei++) {
            // add the new character entering the window
            char ch = s2.charAt(ei);
            mapOfS2Window.put(ch, mapOfS2Window.getOrDefault(ch, 0) + 1);

            // if window length > k, remove the oldest character (at index si)
            if (ei - si + 1 > k) {
                char chLast = s2.charAt(si);
                mapOfS2Window.put(chLast, mapOfS2Window.get(chLast) - 1);

                // clean up if frequency becomes zero
                if (mapOfS2Window.get(chLast) == 0) {
                    mapOfS2Window.remove(chLast);
                }

                // move window start forward
                si++;
            }

            // after adjustment, check if current window matches s1's frequency
            if (mapOfS1.equals(mapOfS2Window)) return true;
        }

        // no permutation found
        return false;
    }

}
