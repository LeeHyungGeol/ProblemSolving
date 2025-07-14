import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
		int answer = 0, sum = 0;

		counter.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 1 ? 1 : -1);
			if (counter.containsKey(sum)) {
				answer = Math.max(answer, i - counter.get(sum));
			} else {
				counter.put(sum, i);
			}
		}

		return answer;
    }
}