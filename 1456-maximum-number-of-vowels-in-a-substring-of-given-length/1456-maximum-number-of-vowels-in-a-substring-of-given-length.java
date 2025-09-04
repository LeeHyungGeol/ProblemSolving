class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0, vowelCount = 0;
        int answer = Integer.MIN_VALUE;

        for (int left = 0, right = 0; right < n; ++right) {
            ++count;
            if (s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' || s.charAt(right) == 'o' || s.charAt(right) == 'u') {
                ++vowelCount;
            }

            if (count == k) {
                answer = Math.max(answer, vowelCount);

                if (s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u') {
                    --vowelCount;
                }
                ++left;
                --count;
            }
        }

        return answer;
    }
}