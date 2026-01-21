package week_2;

public class LC_678_Valid_Parenthesis_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(*))";
		System.out.println(checkValidString(s));

	}
	public static boolean checkValidString(String s) {

        // -----------------------------
        // Pass 1: Left to Right
        // Purpose:
        // Ensure that at no point do we have more ')' than '(' or '*'
        // Here, '*' is treated as '(' (maximum opening possibility)
        // -----------------------------
        int balance = 0; // Tracks possible open parentheses

        for (char ch : s.toCharArray()) {

            // '(' and '*' can act as an opening bracket
            if (ch == '(' || ch == '*') {
                balance++;
            } 
            // ')' must close a previous '(' or '*'
            else {
                balance--;
            }

            // If balance becomes negative, too many ')'
            // No valid interpretation is possible
            if (balance < 0) {
                return false;
            }
        }

        // -----------------------------
        // Pass 2: Right to Left
        // Purpose:
        // Ensure that at no point do we have more '(' than ')' or '*'
        // Here, '*' is treated as ')' (maximum closing possibility)
        // -----------------------------
        balance = 0; // Reset balance for reverse traversal

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // ')' and '*' can act as a closing bracket
            if (ch == ')' || ch == '*') {
                balance++;
            } 
            // '(' must be closed by ')' or '*'
            else {
                balance--;
            }

            // If balance becomes negative, too many '('
            // No valid interpretation is possible
            if (balance < 0) {
                return false;
            }
        }

        // If both passes are valid, the string can be balanced
        return true;
    }

}
