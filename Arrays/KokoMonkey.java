/*
Problem:
Given an array `piles` where each element represents bananas in a pile,
and an integer `h` (hours), find the minimum eating speed `k` such that
all bananas can be eaten within `h` hours.

Approach (Binary Search on Answer):
- The answer (k) lies between 1 and max(piles).
- For a given speed k, we can compute total hours required:
    hours = sum of ceil(piles[i] / k) for all piles.
- If total hours <= h → k is valid (try smaller k).
- If total hours > h → k is too slow (increase k).

Key Idea:
We are minimizing the maximum value (k), so we use binary search
on the search space of possible answers.

Optimization:
- Instead of using Math.ceil, we use:
      ceil(a / b) = (a + b - 1) / b
  to avoid floating-point operations.

Time Complexity:
- O(N * log(max(piles)))
  where N = number of piles

Space Complexity:
- O(1)

Pattern:
This is a classic "Binary Search on Answer" problem,
similar to:
- Capacity to Ship Packages Within D Days
- Allocate Minimum Number of Pages
*/


class Solution {

    public int findMax(int[] piles){
        int max = piles[0];
        for(int i=1; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public long helper(int[] piles, int h){
        long totalH = 0;
        int n = piles.length;
        for(int i=0; i<n; i++){
            totalH += (int)Math.ceil((double)piles[i] /  h);
        }

        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low <= high){
            int mid = low + (high - low)/2;
            long totalH = helper(piles, mid);
            if(totalH <= h){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}
