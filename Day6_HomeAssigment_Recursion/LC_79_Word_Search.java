package Day6_HomeAssigment_Recursion;

public class LC_79_Word_Search {

    public static void main(String[] args) {
        // Create a 2D character board
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        // Word we need to search in the board
        String word = "ABCCED";

        // Flag to store whether the word exists in the board
        boolean ans = false;

        // Iterate through each cell of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // If the first character matches, start DFS search from here
                if (board[i][j] == word.charAt(0)) {

                    // Call the recursive function to check if the word path exists
                    if (isWordPathExist(board, i, j, word, 0)) {
                        ans = true;
                        break; // Word found → no need to check further
                    }
                }
            }
        }

        // Print whether the word exists in the board or not
        System.out.println(ans);
    }

    /**
     * Recursive DFS function to check if the given word can be formed
     * starting from the current position (cr, cc) on the board.
     *
     * @param board The 2D character board
     * @param cr    Current row index
     * @param cc    Current column index
     * @param word  The target word
     * @param idx   Current index in the word being matched
     * @return      True if the word can be formed, false otherwise
     */
    private static boolean isWordPathExist(char[][] board, int cr, int cc, String word, int idx) {

        // Base case: If all characters of the word have been matched
        if (idx == word.length()) {
            return true;
        }

        // Boundary conditions and character mismatch check
        if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length 
                || word.charAt(idx) != board[cr][cc]) {
            return false;
        }

        // Store the current character before marking the cell as visited
        char temp = board[cr][cc];
        board[cr][cc] = '#'; // Mark the cell to avoid revisiting

        // Explore all 4 possible directions (left, right, up, down)
        boolean left = isWordPathExist(board, cr, cc - 1, word, idx + 1);
        boolean right = isWordPathExist(board, cr, cc + 1, word, idx + 1);
        boolean up = isWordPathExist(board, cr - 1, cc, word, idx + 1);
        boolean down = isWordPathExist(board, cr + 1, cc, word, idx + 1);

        // Restore the cell's original value after exploring (backtracking)
        board[cr][cc] = temp;

        // Return true if any of the four directions matched the remaining word
        return left || right || up || down;
    }
}
