import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        if (isArrayElementDistinct(counter)) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < nums.length; i += 3) {
            ++answer;
            for (int j = i; j < Math.min(i + 3, nums.length); ++j) {
                int n = nums[j];
                if (counter.get(n) - 1 == 0) {
                    counter.remove(n);
                } else {
                    counter.put(n, counter.get(n) - 1);
                }
            }
            if (isArrayElementDistinct(counter)) {
                break;
            }
        }

        return answer;
    }

    private boolean isArrayElementDistinct(Map<Integer, Integer> counter) {
        for (int key : counter.keySet()) {
            if (counter.get(key) > 1) {
                return false;
            }
        }

        return true;
    }
}