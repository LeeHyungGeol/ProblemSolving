class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int total = 0;
        int answer = -1;

        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + nums[i];
            total += nums[i];
        }

        for (int i = 0; i < n; ++i) {
            if (sum[i] == total-sum[i]-nums[i]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}