class Solution {
    public long coloredCells(int n) {
        long answer = 0;

        for (int i = 0; i < n; ++i) {
            answer += (2*i)+1;
        }

        for (int i = n-2; i >= 0; --i) {
            answer += (2*i)+1;
        }

        return answer;
    }
}