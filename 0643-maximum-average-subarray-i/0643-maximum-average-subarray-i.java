class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, count = 0;
        double answer = Integer.MIN_VALUE;

        for (int left = 0, right = 0; right< n; ++right) {
            sum += nums[right];
            ++count;

            while (count == k) {
                answer = Math.max(answer, (double)sum/k);

                sum -= nums[left++];
                --count;
            }
        }

        return answer;
    }
}