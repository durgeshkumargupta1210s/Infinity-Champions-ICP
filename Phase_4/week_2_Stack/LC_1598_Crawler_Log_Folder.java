package week_2;
import java.util.*;
public class LC_1598_Crawler_Log_Folder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []logs = {"d1/","d2/","./","d3/","../","d31/"};
		System.out.println(minOperations(logs));

	}
	public static int minOperations(String[] logs) {

        // Stack to keep track of the current directory path
        Stack<String> st = new Stack<>();

        // Iterate through each log operation
        for (String s : logs) {

            // Case 1: "../" → Move to parent directory
            if (s.equals("../")) {

                // Only pop if we are not already at the root directory
                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            // Case 2: "./" → Stay in the current directory
            else if (s.equals("./")) {
                // No action required
                continue;
            }

            // Case 3: "x/" → Move into a child directory
            else {
                // Remove the trailing '/' from the directory name
                String str = s.substring(0, s.length() - 1);

                // Push the directory into the stack
                st.push(str);
            }
        }

        // The size of the stack represents the current depth
        // i.e., the minimum number of operations needed to return to root
        return st.size();
    }

}
