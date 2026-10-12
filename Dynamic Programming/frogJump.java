/*
 * Problem: Frog Jump
 * Approach: Dynamic Programming - Space Optimization
 *
 * 1. The frog can jump either 1 or 2 steps at a time.
 * 2. The cost of a jump is the absolute difference between the heights
 *    of the current and destination steps.
 * 3. Use prev2, prev, and curr to store the minimum costs of the
 *    previous two steps and the current step.
 * 4. At each step, calculate the minimum cost of a 1-step or 2-step jump.
 * 5. Update prev2 and prev to move forward without using a DP array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) auxiliary space
 */


import java.util.*;

public class frogJump {
    
    static int f(int n, int[] heights) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int first = prev + Math.abs(heights[i] - heights[i - 1]);

            int second = Integer.MAX_VALUE;
            if (i > 1) {
                second = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(first, second);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(f(n, heights));

        sc.close();
    }
}
