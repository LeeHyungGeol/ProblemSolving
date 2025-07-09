import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> counter = new HashSet<>();
        int answer = 0, left = 0;

        for (int right = 0; right < s.length(); ++right) {
            if (!counter.contains(s.charAt(right))) {
                counter.add(s.charAt(right));
                answer = Math.max(answer, right-left+1);
            } else {
                while (counter.contains(s.charAt(right))) {
                    counter.remove(s.charAt(left++));
                }
                counter.add(s.charAt(right));
            }
        }

        return answer;
    }
}