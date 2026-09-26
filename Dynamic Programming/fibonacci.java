/*
 * Fibonacci Number using Iterative Approach
 *
 * Approach:
 * - Maintain the previous two Fibonacci numbers using prev2 and prev.
 * - Calculate the current number as prev + prev2.
 * - Shift the values for the next iteration.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }

        System.out.println(prev);
    }
}