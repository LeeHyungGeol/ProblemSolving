class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = 0; // 고유 문자의 개수

        // 각 문자별 필요한 개수 저장
        int[] req = new int[256];
        for (char c : t.toCharArray()) {
            if (++req[c] == 1) { // 처음 등장하는 문자라면
                m++; // 고유 문자 개수 증가
            }
        }

        String res = "";
        int charCount = 0; // 요구사항을 만족시키는 글자의 개수
        int[] cnt = new int[256]; // 현재 윈도우의 각 문자별 개수

        for (int L = 0, R = 0; R < n; R++) {
            // update right
            if (++cnt[s.charAt(R)] == req[s.charAt(R)]) {
                charCount++; // 만족시키는 글자의 개수
            }

            // update left
            while (charCount == m) {
                // update answer - [L, R] (현재 유효한 윈도우)
                int len = R - L + 1;
                if (res.isEmpty() || res.length() > len) {
                    res = s.substring(L, R+1);
                }

                // 왼쪽 문자 제거
                int c = s.charAt(L++);
                if (--cnt[c] < req[c]) {
                    charCount--;
                }
            }
        }

        return res;
    }
}