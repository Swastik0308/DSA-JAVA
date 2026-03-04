/*
Problem:
Count the number of subarrays whose sum equals K.

https://leetcode.com/problems/subarray-sum-equals-k/

Example:
arr = [10, 2, -2, -20, 10]
k = -10

Valid subarrays:
[10, 2, -2, -20] -> sum = -10
[2, -2, -20, 10] -> sum = -10
[-20, 10] -> sum = -10

Answer = 3

Approach (Prefix Sum + HashMap):

Let prefixSum[j] = sum of elements from index 0 to j.

If a subarray (i+1 ... j) has sum = k, then:

prefixSum[j] - prefixSum[i] = k

Rearranging:

prefixSum[i] = prefixSum[j] - k

So while traversing the array:
1. Maintain a running prefix sum.
2. Check if (sum - k) already appeared before.
3. If yes, then there exist subarrays ending at index j with sum = k.
4. Add the frequency of (sum - k) to the answer.
5. Store/update the frequency of the current prefix sum.

Why map.put(0,1)?
This handles cases where a subarray starting from index 0 has sum = k.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class SubarraySumEqualK {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(ans);
    }
}
