class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            ++frequency[c-'a'];
        }

        for (int time = 0; time < t; ++time) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; ++i) {
                if (i == 25) {
                    temp[0] += frequency[25] % MOD;
                    temp[1] += frequency[25] % MOD;
                    frequency[25] = 0;
                    break;
                }
                temp[i+1] = frequency[i] % MOD;
                frequency[i] = 0;
            }
            for (int i = 0; i < 26; ++i) {
                frequency[i] = temp[i] % MOD;
            }
        }
        
        long answer = 0;
        for (int x : frequency) {
            answer = (answer + x) % MOD;
        }

        return (int) answer;
    }
}