import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        int[] counter = new int[26];
        int maxVowelFreq = 0, maxConsonantFreq = 0;

        for (char c : s.toCharArray()) {
            ++counter[c-'a'];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                maxVowelFreq = Math.max(maxVowelFreq, counter[c-'a']);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, counter[c-'a']);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}