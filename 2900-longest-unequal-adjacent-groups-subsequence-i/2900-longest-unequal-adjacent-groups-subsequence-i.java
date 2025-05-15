import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> answer = new ArrayList<>();
        int wordsLength = words.length;

        for (int i = 0; i < wordsLength; ++i) {
            if (i == 0 || groups[i] != groups[i-1]) {
                answer.add(words[i]);
            }
        }

        return answer;
    }
}