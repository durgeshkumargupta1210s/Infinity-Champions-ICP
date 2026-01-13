package Test3_Coding_Problems;

public class LC_2038_Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {

    public static void main(String[] args) {
        // Example input string representing the colors
        String colors = "AAABABB";

        // Call the method to check if Alice wins
        System.out.println(winnerOfGame(colors));
    }

    /**
     * Method to determine the winner of the game.
     * Alice can remove 'A' if both neighbors are 'A'.
     * Bob can remove 'B' if both neighbors are 'B'.
     * Whoever has more possible moves at the start will win.
     *
     * @param colors String of characters 'A' and 'B' representing the game state
     * @return true if Alice wins, false if Bob wins
     */
    public static boolean winnerOfGame(String colors) {
        int aCount = 0; // Counter for Alice's possible moves
        int bCount = 0; // Counter for Bob's possible moves

        // Convert string to character array for easier access
        char[] ch = colors.toCharArray();

        // Traverse the string from the second character to the second-last character
        // because only middle characters can be removed
        for (int i = 1; i < colors.length() - 1; i++) {

            // Check if the current character and its neighbors form 'AAA'
            // This means Alice can remove the middle 'A'
            if (ch[i - 1] == 'A' && ch[i] == 'A' && ch[i + 1] == 'A') {
                aCount++; // Increment Alice's move count
            }

            // Check if the current character and its neighbors form 'BBB'
            // This means Bob can remove the middle 'B'
            if (ch[i - 1] == 'B' && ch[i] == 'B' && ch[i + 1] == 'B') {
                bCount++; // Increment Bob's move count
            }
        }

        // Alice wins if she has more possible moves than Bob
        return aCount > bCount;
    }
}
