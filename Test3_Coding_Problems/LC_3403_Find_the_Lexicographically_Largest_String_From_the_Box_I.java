package Test3_Coding_Problems;

public class LC_3403_Find_the_Lexicographically_Largest_String_From_the_Box_I {

    public static void main(String[] args) {
        String word = "dbca";
        int numFriends = 2;

        // Call the function and print the result
        System.out.println(answerString(word, numFriends));  // Expected output: "dbc"
    }

    /**
     * Returns the lexicographically largest string that can be obtained
     * by splitting the given word into 'numFriends' non-empty parts
     * in all possible unique ways, and picking the largest substring
     * that would end up in the box after all splits.
     *
     * Optimized greedy approach:
     * - We don't generate all combinations (inefficient for large input).
     * - Instead, we use the property that the longest substring we can take
     *   starts at some index and has a maximum length of (n - numFriends + 1).
     * - We check every possible starting index, take the substring up to maxLength,
     *   and keep track of the lexicographically largest one.
     */
    public static String answerString(String word, int numFriends) {
        int n = word.length();

        // If only one friend, the entire word is the only substring
        if (numFriends == 1) return word;

        // Maximum length of any substring we can consider
        // because we must leave at least (numFriends - 1) characters
        // for the other friends in the split.
        int maxLength = n - (numFriends - 1);

        // Variable to store the lexicographically largest substring found so far
        String str = "";

        // Iterate over each possible starting index of the substring
        for (int i = 0; i < n; i++) {
            // Calculate the end index (don't go beyond string length)
            int end = Math.min(n, i + maxLength);

            // Extract the substring starting at 'i' up to 'end'
            String newStr = word.substring(i, end);

            // Compare lexicographically and keep the larger one
            if (newStr.compareTo(str) > 0) {
                str = newStr;
            }
        }

        // Return the largest substring found
        return str;
    }
}
