class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;

        if (!zero(nums, queries, queries.length)) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (zero(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean zero(int[] nums, int[][] queries, int queryLength) {
        int sum = 0;
        int[] prefixSum = new int[nums.length+1];

        for (int i = 0; i < queryLength; ++i) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            prefixSum[l] += val;
            prefixSum[r+1] -= val;
        }

        for (int i = 0; i < nums.length; ++i) {
            sum += prefixSum[i];
            if (sum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}