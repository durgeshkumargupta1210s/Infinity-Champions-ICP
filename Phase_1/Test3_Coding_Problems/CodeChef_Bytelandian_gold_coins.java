package Test3_Coding_Problems;

import java.util.*;

public class CodeChef_Bytelandian_gold_coins {

    // Memoization map to store results of subproblems (key: n, value: max coins for n)
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        long n = 12;  // Example input value
        System.out.println(calculateCoin(n));  // Expected output: 13
    }

    /**
     * Recursively calculates the maximum number of coins obtainable
     * from exchanging or keeping a coin of value n.
     *
     * @param n the value of the coin
     * @return the maximum number of coins obtainable
     */
    private static long calculateCoin(long n) {
        // Base case: if n is 0, no coins can be exchanged
        if (n == 0) {
            return 0;
        }

        // If result for this n is already computed, return it directly (memoization)
        if (map.containsKey(n)) {
            return map.get(n);
        }

        // Recursively compute values for n/2, n/3, and n/4
        long n_2 = calculateCoin(n / 2);
        long n_3 = calculateCoin(n / 3);
        long n_4 = calculateCoin(n / 4);

        // Option 1: Keep the coin as it is → value = n
        // Option 2: Exchange the coin into n/2, n/3, n/4 and get their max value recursively
        long result = Math.max(n, (n_2 + n_3 + n_4));

        // Store the computed result in the map for future use (memoization)
        map.put(n, result);

        // Return the final result for this n
        return result;
    }
}
