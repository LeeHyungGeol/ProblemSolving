import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<>();
        int answer = 0, left = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); ++right) {
            char rightChar = s.charAt(right);
            counter.put(rightChar, counter.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, counter.get(rightChar));

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                counter.put(leftChar, counter.get(leftChar) - 1);
                ++left;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}