/*
Problem:
Find the length of the longest subarray with sum equal to 0.

https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Approach:
We use the prefix sum technique with a HashMap.

Key Idea:
If the same prefix sum appears again, it means the elements between those
two indices sum to 0.

Example:
Array = [15, -2, 2, -8, 1, 7, 10, 23]

Prefix sums:
Index : 0   1   2   3   4   5   6   7
Value :15  13  15   7   8  15  25  48

Notice prefix sum 15 appears multiple times:
first at index 0 and again at index 2 → subarray (1..2) sum = 0
again at index 5 → subarray (1..5) sum = 0

Algorithm:
1. Traverse the array and maintain a running prefix sum.
2. Store the first occurrence of each prefix sum in a HashMap.
3. If the same sum appears again at index j:
      subarray length = j - firstIndex
4. Update the maximum length.

Why store first occurrence?
To maximize the length of the subarray.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class SubarraySumToZero {
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }

        }
        System.out.println(len);
    }
}
