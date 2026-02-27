/*
 * Problem: Majority Element II (n/3 case)
 *Related Question: https://leetcode.com/problems/majority-element-ii/
 * 
 * Given an integer array, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Approach Used:
 * 1. Use a HashMap<Integer, Integer> to store frequency of each element.
 * 2. Traverse the array once and update frequency using getOrDefault().
 * 3. Traverse the map and print elements whose frequency > n/3.
 *
 * Why n/3?
 * If an element appears more than n/3 times, there can be at most 2 such elements.
 * (Because 3 elements each > n/3 would exceed total n.)
 *
 * Time Complexity:
 * - O(n) → One pass for counting + one pass over unique keys (≤ n)
 *
 * Space Complexity:
 * - O(n) → In worst case, all elements are distinct and stored in HashMap.
 *
 * Important Points:
 * - HashMap does not maintain insertion order.
 * - getOrDefault() avoids manual containsKey() checking.
 * - This is NOT the optimal solution in terms of space.
 *   Optimal solution uses Boyer-Moore Voting Algorithm (O(1) space).
 *
 * Edge Cases:
 * - Empty array → No output
 * - All elements same → That element is printed
 * - No element > n/3 → Nothing printed
 *
 * Note:
 * This solution is easy to understand and good for beginners,
 * but in interviews you should mention the O(1) space optimization.
 */

import java.util.*;

public class MajorityElementII {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // if(map.containsKey(arr[i])){
            // map.put(arr[i], map.get(arr[i])+1);
            // } else {
            // map.put(arr[i], 1);
            // }

            // Short cut for above if's
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }
}
