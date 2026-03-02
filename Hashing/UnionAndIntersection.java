/*
 * Program: UnionAndIntersection
 *
 * Purpose:
 * --------
 * This program finds:
 * 1) The number of elements in the UNION of two integer arrays.
 * 2) The number of elements in the INTERSECTION of two integer arrays.
 *
 * Approach:
 * ---------
 * UNION:
 * - A HashSet is used to store elements from both arrays.
 * - Since HashSet does not allow duplicates, adding all elements from
 *   arr1 and arr2 automatically keeps only distinct values.
 * - The size of the HashSet gives the total number of unique elements
 *   present in both arrays (Union count).
 *
 * INTERSECTION:
 * - The HashSet is cleared and filled again with elements of arr1.
 * - We iterate through arr2 and check:
 *      if an element exists in the set,
 *      it is common to both arrays.
 * - We increment the count and remove the element from the set
 *   to avoid counting duplicates multiple times.
 *
 * Time Complexity:
 * - O(n + m), where n = size of arr1 and m = size of arr2.
 * - HashSet add(), contains(), and remove() are O(1) on average.
 *
 * Space Complexity:
 * - O(n) in the worst case (for storing elements of arr1).
 *
 * Example:
 * arr1 = {7, 3, 9}
 * arr2 = {6, 3, 9, 2, 9, 4}
 *
 * Union = {7, 3, 9, 6, 2, 4} → 6
 * Intersection = {3, 9} → 2
 */

import java.util.HashSet;

public class UnionAndIntersection {

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union = " + set.size());

        set.clear();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection = " + count);
    }
}
