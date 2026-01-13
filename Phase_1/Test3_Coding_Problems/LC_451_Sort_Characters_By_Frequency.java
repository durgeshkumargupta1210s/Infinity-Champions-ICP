package Test3_Coding_Problems;

import java.util.*;

public class LC_451_Sort_Characters_By_Frequency {

    public static void main(String[] args) {
        // Input string
        String s = "tree";

        // Step 1: Count frequency of each character using a HashMap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Increment the count of the character 'ch'
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create a Max-Heap (PriorityQueue) to sort characters by frequency (high → low)
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> {
                // Compare based on frequency stored in 'map'
                return map.get(b) - map.get(a);
            }
        );

        // Add all distinct characters into the max-heap
        pq.addAll(map.keySet());

        // Step 3: Build the result string using characters in order of decreasing frequency
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            // Get the character with highest remaining frequency
            char ch = pq.poll();

            // Append the character 'frequency' number of times
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }

        // Step 4: Print the result
        System.out.println(sb.toString());
    }
}
