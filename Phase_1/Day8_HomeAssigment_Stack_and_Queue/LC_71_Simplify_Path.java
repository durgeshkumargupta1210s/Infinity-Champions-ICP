package Day8_HomeAssigment_Stack_and_Queue;

import java.util.Stack;

public class LC_71_Simplify_Path {

    /**
     * Function to simplify a Unix-style absolute path
     *
     * Rules:
     * 1. "." → current directory, ignore it
     * 2. ".." → move to parent directory (pop last valid dir from stack)
     * 3. multiple "/" → treated as single "/"
     * 4. valid directory names → push to stack
     *
     * @param path - input absolute path
     * @return simplified canonical path
     */
    public static String simplifyPath(String path) {
        // Split the path by "/" to get individual components
        String[] parts = path.split("/"); 

        // Stack to store valid directory names
        Stack<String> stack = new Stack<>();

        // Process each part of the path
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty strings (from "//") and "." (current directory)
                continue;
            } else if (part.equals("..")) {
                // ".." means go back to parent directory if stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name → push onto stack
                stack.push(part);
            }
        }

        // Reconstruct the simplified path from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir); // append "/" before each dir
        }

        // If stack is empty, the simplified path is root "/"
        return result.length() == 0 ? "/" : result.toString();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/a/./b/../../c/";
        String path3 = "/../";
        String path4 = "/home//foo/";

        System.out.println(simplifyPath(path1)); // Output: /home
        System.out.println(simplifyPath(path2)); // Output: /c
        System.out.println(simplifyPath(path3)); // Output: /
        System.out.println(simplifyPath(path4)); // Output: /home/foo
    }
}
