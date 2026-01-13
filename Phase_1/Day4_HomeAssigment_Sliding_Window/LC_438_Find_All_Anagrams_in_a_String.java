package Day4_HomeAssigment_Sliding_Window;
import java.util.*;
public class LC_438_Find_All_Anagrams_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = findAnagrams(s,p);
		

	}
	
	 public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list = new ArrayList<>();

	        // Frequency map for string p (pattern we want to match)
	        HashMap<Character,Integer> mapOfP = new HashMap<>();

	        // Frequency map for the current sliding window in s
	        HashMap<Character,Integer> mapOfPWindow = new HashMap<>();

	        int k = p.length();   // size of the window = length of p
	        int si = 0;           // left pointer (start index of window)

	        // Build frequency map of characters in p
	        for (char ch : p.toCharArray()) {
	            mapOfP.put(ch, mapOfP.getOrDefault(ch, 0) + 1);
	        }

	        // Build the frequency map for the first window of length k in s
	        for (int i = 0; i < k && i < s.length(); i++) {
	            char ch = s.charAt(i);
	            mapOfPWindow.put(ch, mapOfPWindow.getOrDefault(ch, 0) + 1);
	        }

	        // If the first window matches, add starting index 0
	        if (mapOfP.equals(mapOfPWindow)) list.add(si);

	        // Slide the window across string s
	        for (int ei = k; ei < s.length(); ei++) {
	            // Add new character entering the window
	            char ch = s.charAt(ei);
	            mapOfPWindow.put(ch, mapOfPWindow.getOrDefault(ch, 0) + 1);

	            // Shrink the window if its size exceeds k
	            while (ei - si + 1 > k) {
	                char lastChar = s.charAt(si);
	                mapOfPWindow.put(lastChar, mapOfPWindow.get(lastChar) - 1);

	                // Remove char from map if its count becomes zero
	                if (mapOfPWindow.get(lastChar) == 0) {
	                    mapOfPWindow.remove(lastChar);
	                }

	                // Move window start forward
	                si++;
	            }

	            // If current window matches the frequency map of p, record start index
	            if (mapOfP.equals(mapOfPWindow)) list.add(si);
	        }

	        return list;
	    }

}
