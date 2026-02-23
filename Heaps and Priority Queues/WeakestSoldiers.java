/*
 * Problem: Find the K Weakest Rows in a Binary Matrix
 *
 * Related question: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 * A row is considered weaker if:
 * 1) It has fewer soldiers (1s)
 * 2) If two rows have the same number of soldiers,
 *    the row with the smaller index is weaker.
 *
 * Approach:
 * - For each row, count the number of soldiers.
 * - Store (soldierCount, rowIndex) in a min-heap (PriorityQueue).
 * - Use a custom Comparable to sort:
 *      -> First by soldier count (ascending)
 *      -> Then by index (ascending)
 * - Remove the top k elements from the heap to get k weakest rows.
 *
 * Time Complexity:
 * - Counting soldiers: O(m * n)
 * - Inserting m rows into heap: O(m log m)
 * - Removing k elements: O(k log m)
 * => Overall: O(m * n + m log m)
 *
 * Space Complexity:
 * - O(m) for the priority queue.
 *
 * Interview Notes:
 * - This works because Java's PriorityQueue is a Min-Heap by default.
 * - Custom sorting logic must strictly follow the problem condition.
 * - Since rows are sorted (1s followed by 0s), soldier count can be optimized
 *   using Binary Search to O(log n) instead of O(n) per row.
 */

import java.util.PriorityQueue;

public class WeakestSoldiers {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else
                return this.soldiers - r2.soldiers;
        }

    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
