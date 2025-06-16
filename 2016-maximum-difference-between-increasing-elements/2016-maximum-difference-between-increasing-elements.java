class Solution {
    public int maximumDifference(int[] nums) {
        int answer = -1, min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > min) {
                answer = Math.max(answer, nums[i] - min);
            } else {
                min = nums[i];
            }
        }

        return answer;
    }
}