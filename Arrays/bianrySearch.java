class Solution {
    public int search(int[] nums, int tar) {

        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (nums[mid] == tar) {
                return mid;
            }

            else if (tar < nums[mid]) {
                end = mid - 1;
            }

            else {
                st = mid + 1;
            }
        }

        return -1;
    }
}
