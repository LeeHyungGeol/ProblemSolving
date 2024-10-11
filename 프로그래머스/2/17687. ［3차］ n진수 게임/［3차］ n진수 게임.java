class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int order = 1, turn = p, count = t;
        
        for (int i = 0; i <= m*t; ++i) {
            for (String s : Integer.toString(i, n).split("")) {
                if (count == 0) break;
                if (order == turn) {
                    sb.append(s);
                    turn += m;
                    --count;
                }
                ++order;
            }
        }
        
        return sb.toString().toUpperCase();
    }
}