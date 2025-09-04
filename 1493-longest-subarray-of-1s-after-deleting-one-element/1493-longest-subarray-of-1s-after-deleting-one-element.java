class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int answer = 0;

        for (int left = 0, right = 0; right < n; ++right) {
            if (nums[right] == 0) {
                ++zeroCount;
            }

            while (zeroCount > 1) {
                if (nums[left++] == 0) {
                    --zeroCount;
                }
            }

            answer = Math.max(answer, right-left);
        }

        return answer;
    }
}