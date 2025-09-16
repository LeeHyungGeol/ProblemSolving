class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n+1];
        int[] rightSum = new int[n+1];
        int answer = -1;

        for (int i = 0; i < n; ++i) {
            leftSum[i+1] = leftSum[i] + nums[i];
        }

        for (int i = n-1; i >= 0; --i) {
            rightSum[i] = rightSum[i+1] + nums[i];
        }

        for (int i = 0; i < n; ++i) {
            if (leftSum[i] == rightSum[i+1]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}