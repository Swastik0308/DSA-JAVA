// class Solution {
//     public void rotate(int[] nums, int k) {
//         // int n = nums.length;
//         // k = k % n;   // always normalize

//         // int[] result = new int[n];

//         // for (int i = 0; i < n; i++) {
//         //     result[(i + k) % n] = nums[i];
//         // }

//         // // copy back to original array
//         // for (int i = 0; i < n; i++) {
//         //     nums[i] = result[i];
//         // }


      
        
//     }
// }


//With constant space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
