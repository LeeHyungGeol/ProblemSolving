import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long answer = 0, left = 0, maxElementAppearances = 0;

        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == max) {
                ++maxElementAppearances;
            }

            while (maxElementAppearances >= k) {
                if (nums[(int) left] == max) {
                    --maxElementAppearances;
                }
                ++left;
            }

            answer += left;
        }

        return answer;
    }
}