/*
 * Program: CountUniqueElements
 *
 * Related Question: https://www.geeksforgeeks.org/problems/find-distinct-elements
 * Purpose:
 * --------
 * This program counts the number of unique elements present in an integer array.
 *
 * Approach:
 * ---------
 * 1. A HashSet is used because it stores only distinct elements (no duplicates allowed).
 * 2. We iterate through the array and add each element to the HashSet.
 * 3. Since HashSet automatically ignores duplicate values, only unique elements remain.
 * 4. Finally, we print the size of the HashSet, which represents the total number of unique elements.
 *
 * Time Complexity: O(n)
 * - We traverse the array once.
 * - Insertion in HashSet is O(1) on average.
 *
 * Space Complexity: O(n)
 * - In the worst case (all elements unique), we store n elements in the HashSet.
 *
 * Example:
 * Input:  {4, 3, 2, 5, 6, 7, 3, 4, 2, 1}
 * Output: 7
 */

import java.util.HashSet;

public class CountUniqueElements {
    public static void main(String[] args) {
        int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        System.out.println(set.size());
    }
}
