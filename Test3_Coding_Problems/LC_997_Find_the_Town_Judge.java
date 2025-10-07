package Test3_Coding_Problems;

public class LC_997_Find_the_Town_Judge {

    public static void main(String[] args) {
        // Example input: n = number of people, trust = pairs [a, b] where a trusts b
        int n = 2;
        int [][]trust = {{1,2}};

        // Call the function and print the result
        System.out.println(findJudge(n, trust));
    }

    /**
     * Function to find the town judge.
     *
     * @param n     Total number of people in the town (labeled 1 to n)
     * @param trust Array of trust relationships; trust[i] = [a, b] means person a trusts person b
     * @return The label of the town judge, or -1 if no judge exists
     */
    public static int findJudge(int n, int[][] trust) {
        // Array to track number of people who trust each person (in-degree)
        int[] indegree = new int[n + 1];

        // Array to track number of people each person trusts (out-degree)
        int[] outdegree = new int[n + 1];

        // Process each trust relationship
        for (int[] ele : trust) {
            int a = ele[0]; // person who trusts someone
            int b = ele[1]; // person who is trusted

            outdegree[a]++;  // person a trusts someone → increment out-degree
            indegree[b]++;   // person b is trusted → increment in-degree
        }

        // Check each person to find the judge
        for (int i = 1; i <= n; i++) {
            // Judge criteria:
            // 1. Trusted by everyone else → indegree[i] == n - 1
            // 2. Trusts nobody → outdegree[i] == 0
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;  // Found the town judge
            }
        }

        // If no person satisfies the judge conditions, return -1
        return -1;
    }
}
