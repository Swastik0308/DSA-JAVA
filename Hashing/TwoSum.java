class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;

            if(hm.containsKey(second)) {
                return new int[]{hm.get(second), i};
            }

            hm.put(first, i);
        }

        return new int[]{};
    }
}
