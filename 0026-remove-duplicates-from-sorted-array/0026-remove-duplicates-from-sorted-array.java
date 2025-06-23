class Solution {
    public int removeDuplicates(int[] nums) {
        int k = -101, index = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != k) {
                nums[index++] = nums[i];
                k = nums[i];
            }
        }

        return index;
    }
}