/*
 * K NEAREST CARS TO ORIGIN (0,0)
 * Related Question: https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * This program finds the k closest cars (points) to the origin using a Min-Heap.
 *
 * APPROACH:
 * - For each point (x, y), compute squared distance:
 *        distSq = x^2 + y^2
 * - Store each point in a PriorityQueue (Min-Heap) ordered by distSq.
 * - Remove the top k elements from the heap.
 *   Since it's a Min-Heap, the smallest distances come out first.
 *
 * WHY SQUARED DISTANCE?
 * - We avoid using sqrt() because it is unnecessary for comparison.
 * - Comparing x^2 + y^2 gives the same ordering as sqrt(x^2 + y^2).
 *
 * DATA STRUCTURE USED:
 * - Java PriorityQueue (Min-Heap by default)
 * - Custom class implements Comparable to define ordering by distance.
 *
 * TIME COMPLEXITY:
 * - Inserting n points → O(n log n)
 * - Removing k points → O(k log n)
 * - Overall → O(n log n)
 *
 * SPACE COMPLEXITY:
 * - O(n) for storing all points in the heap.
 *
 * NOTE:
 * This can be optimized to O(n log k) by maintaining a Max-Heap of size k
 * instead of inserting all elements.
 *
 * Use Case:
 * This pattern is common in “Top K” problems such as:
 * - K closest points
 * - K largest elements
 * - K most frequent elements
 */

import java.util.PriorityQueue;

public class NearbyCars {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // nearest k cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }

    }
}
