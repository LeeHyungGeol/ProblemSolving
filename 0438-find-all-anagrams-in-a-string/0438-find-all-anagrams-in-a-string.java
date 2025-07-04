public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        if(p.length()> s.length()) {
            return answer;
        }

        int[] sPattern = new int[26];
        int[] pPattern = new int[26];
        int left = 0, right = 0;

        for (char c : p.toCharArray()) {
            ++pPattern[c-'a'];
        }

        while (right < s.length()) {
            ++sPattern[s.charAt(right)-'a'];

            if ((right-left+1) < p.length()) {
                ++right;
            } else {
                if (Arrays.equals(sPattern, pPattern)) {
                    answer.add(left);
                }
                --sPattern[s.charAt(left)-'a'];
                ++left;
                ++right;
            }
        }

        return answer;
    }
}