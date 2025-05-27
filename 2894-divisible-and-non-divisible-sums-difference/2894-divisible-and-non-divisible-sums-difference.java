class Solution {
    public int differenceOfSums(int n, int m) {
        int answer = 0;

        for (int i = 1; i <= n; ++i) {
            if (i%m == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }
}