/*
 * CONNECT N ROPES WITH MINIMUM COST
 *Related Question: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 * 
 * PROBLEM:
 * Given N ropes with different lengths, we must connect them into one rope.
 * The cost of connecting two ropes = sum of their lengths.
 * Goal: Minimize the total cost of all connections.
 *
 * APPROACH (Greedy + Min-Heap):
 * - Always connect the two smallest ropes first.
 * - This is a greedy decision that works because:
 *      Smaller ropes contribute less to future cumulative costs.
 * - A Min-Heap (PriorityQueue) allows efficient extraction of
 *      the two smallest ropes at every step.
 *
 * WHY NOT JUST SORT ONCE AND CONNECT SEQUENTIALLY?
 * - If we sort once and keep adding left to right,
 *   we may miss better combinations formed after merges.
 * - After each merge, a new rope is formed which must be
 *   reinserted into the structure at the correct position.
 * - Without a heap (or re-sorting every time),
 *   we may not always pick the current two smallest ropes.
 * - That would break optimality and produce a higher total cost.
 *
 * WHY while (pq.size() > 1) and NOT while (!pq.isEmpty()) ?
 * - Each iteration removes TWO ropes and inserts ONE combined rope.
 * - When only one rope remains, no more connections are possible.
 * - Using !pq.isEmpty() would attempt to remove two elements
 *   when only one exists → runtime error.
 *
 * WHY IS COST STORED SEPARATELY AND NOT IN THE HEAP?
 * - The heap only maintains rope lengths needed for future merges.
 * - Total cost is cumulative and unrelated to heap ordering.
 * - Inserting cost into the heap would distort the selection logic.
 *
 * TIME COMPLEXITY:
 * - Insert N ropes → O(n log n)
 * - Perform (n - 1) merge operations → O(n log n)
 * - Overall → O(n log n)
 *
 * SPACE COMPLEXITY:
 * - O(n) for the Min-Heap
 *
 * PATTERN:
 * This problem is identical in structure to:
 * - Huffman Coding
 * - Optimal Merge Pattern
 * - Minimum Cost to Merge Files
 *
 * KEY INSIGHT:
 * Whenever a problem asks to repeatedly combine the two smallest elements
 * to minimize total cost → use Greedy + Min-Heap.
 */

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static void main(String[] args) {
        int ropes[] = { 2, 3, 3, 4, 6 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }

        System.out.println(cost);
    }
}
