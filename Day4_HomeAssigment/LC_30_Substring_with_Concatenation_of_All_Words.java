package Day4_HomeAssigment;

import java.util.*;

public class LC_30_Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		// Test case
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};

		// Output should be [0, 9]
		System.out.println(findSubstring(s, words));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();

		// Edge case: if input is empty
		if (s.length() == 0 || words.length == 0) return list;

		// Length of each word (all words have same length as per problem)
		int wordLen = words[0].length();
		// Total number of words
		int wordCount = words.length;
		// Total length of all words combined
		int totalLen = wordLen * wordCount;

		// If the string is shorter than total length, no valid substring exists
		if (s.length() < totalLen) return list;

		// Step 1: Build a frequency map of all words
		// Example: words = ["foo","bar"] → {"foo":1, "bar":1}
		Map<String, Integer> wordMap = new HashMap<>();
		for (String w : words) {
			wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
		}

		// Step 2: There can be multiple possible starting alignments
		// For example: if wordLen = 3 → we check substrings starting at index 0, 1, and 2
		for (int i = 0; i < wordLen; i++) {

			// left → start of the current sliding window
			// right → end of the current sliding window
			int left = i;
			int right = i;

			// matched → number of valid words matched so far in the current window
			int matched = 0;

			// Map to store frequency of words currently in the window
			Map<String, Integer> seen = new HashMap<>();

			// Step 3: Move the right pointer in steps of wordLen
			while (right + wordLen <= s.length()) {
				// Extract a word of length 'wordLen' starting at 'right'
				String word = s.substring(right, right + wordLen);
				right += wordLen; // move right pointer forward

				// If the word exists in our required wordMap
				if (wordMap.containsKey(word)) {
					// Count this word in the current window
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					matched++;

					// If the current word frequency exceeds the required frequency,
					// shrink the window from the left until it becomes valid
					while (seen.get(word) > wordMap.get(word)) {
						String leftWord = s.substring(left, left + wordLen);
						seen.put(leftWord, seen.get(leftWord) - 1);
						matched--;
						left += wordLen; // shrink from left
					}

					// If all words are matched → valid substring found
					if (matched == wordCount) {
						list.add(left);
					}

				} else {
					// If the word is not part of the words list,
					// reset the window completely
					seen.clear();
					matched = 0;
					left = right;
				}
			}
		}

		return list;
	}
}
