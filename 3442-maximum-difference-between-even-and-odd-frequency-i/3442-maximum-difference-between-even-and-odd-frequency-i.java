import java.util.*;

class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int oddMax = 0, evenMin = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddMax = Math.max(entry.getValue(), oddMax);
            } else {
                evenMin = Math.min(entry.getValue(), evenMin);
            }
        }

        return oddMax-evenMin;
    }
}