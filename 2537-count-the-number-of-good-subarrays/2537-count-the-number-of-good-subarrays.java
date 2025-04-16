import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        long answer = 0;
        int same = 0, r = -1;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int l = 0; l < nums.length; ++l) {
            while (same < k && r + 1 < nums.length) {
                ++r;
                same += counter.getOrDefault(nums[r], 0);
                counter.put(nums[r], counter.getOrDefault(nums[r], 0) + 1);
            }

            if (same >= k) {
                answer += nums.length - r;
            }

            counter.put(nums[l], counter.get(nums[l])- 1);
            same -= counter.get(nums[l]);
        }

        return answer;
    }
}