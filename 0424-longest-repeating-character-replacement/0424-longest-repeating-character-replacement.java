import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int answer = 0, left = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); ++right) {
            char rightChar = s.charAt(right);
            ++counter[rightChar-'A'];
            maxFreq = Math.max(maxFreq, counter[rightChar-'A']);

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                --counter[leftChar-'A'];
                ++left;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}