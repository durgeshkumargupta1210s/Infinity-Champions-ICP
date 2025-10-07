package Test3_Coding_Problems;

import java.util.*;

public class LC_49_Group_Anagrams {

	public static void main(String[] args) {
		// Input array of strings
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		// Call the function to group anagrams
		List<List<String>> result = groupAnagrams(strs);
		
		// Print the result
		System.out.println(result);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		// Map to store sorted string as key and list of original strings as value
		// Example: "aet" -> ["eat", "tea", "ate"]
		Map<String, List<String>> map = new HashMap<>();

		// Iterate through each string in the input array
		for (String str : strs) {
			// Convert the string into a char array for sorting
			char[] arr = str.toCharArray();
			
			// Sort the characters alphabetically
			Arrays.sort(arr);
			
			// Convert the sorted character array back to a string
			String sorted = new String(arr);

			// If this sorted key doesn't exist in the map, create a new entry
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}

			// Add the original string to the list corresponding to the sorted key
			map.get(sorted).add(str);
		}

		// Return all the grouped anagrams as a list of lists
		return new ArrayList<>(map.values());
	}
}
