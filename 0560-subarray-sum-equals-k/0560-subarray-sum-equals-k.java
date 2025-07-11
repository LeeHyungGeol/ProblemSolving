class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0, sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}