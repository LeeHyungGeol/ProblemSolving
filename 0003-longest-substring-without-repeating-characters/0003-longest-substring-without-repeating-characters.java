class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] counter = new int[128];
        int answer = 0;

        for (int left = 0, right = 0; right < s.length(); ++right) {
            // update right
            counter[s.charAt(right)]++;

            // update left
            while (counter[s.charAt(right)] > 1) {
                counter[s.charAt(left++)]--;
            }

            answer = Math.max(answer, right-left+1);
        }

        return answer;
    }
}