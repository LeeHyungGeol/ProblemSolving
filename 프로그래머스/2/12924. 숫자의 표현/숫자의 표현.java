class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[10_001];
        
        for (int i = 1; i <= n; ++i) {
            for(int j = i; j <= n; ++j) {
                dp[i] += j;
                if (dp[i] == n) {
                    ++answer;
                    break;
                }
                if (dp[i] > n) break;
            }
        }
        
        return answer;
    }
}