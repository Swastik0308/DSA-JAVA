/*
 * Problem: Sliding Window Maximum
 *
 * Given an array and a window size k, find the maximum element
 * in every contiguous subarray (window) of size k.
 *
 * Approach (Max-Heap / Priority Queue):
 * - Use a max-heap storing (value, index).
 * - Insert first k elements into the heap.
 * - The top of heap gives maximum of current window.
 * - For each new element:
 *      1) Remove elements from heap whose index is outside the window.
 *      2) Insert current element.
 *      3) Top of heap is current window maximum.
 *
 * Time Complexity:
 * - Each insertion: O(log k)
 * - Each removal: O(log k)
 * - For n elements: O(n log k)
 *
 * Space Complexity:
 * - O(k) for the heap.
 *
 * Important Interview Notes:
 * - This is NOT the most optimal solution.
 * - Optimal solution uses Monotonic Deque with O(n) time.
 * - Heap solution is easier to write but slower.
 * - Always store index to remove outdated elements.
 */

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val; // descending order
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 6, 7 };
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();

            }

            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
