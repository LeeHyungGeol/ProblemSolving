class Solution {
    public int countSubarrays(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; ++i) {
            if (doesSubArrayMeetCondition(nums[i], nums[i+1], nums[i+2])) {
                ++answer;
            }
        }

        return answer;
    }

    private boolean doesSubArrayMeetCondition(int a, int b, int c) {
        return (a+c)*2 == b;
    }
}