import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;

        Arrays.sort(dungeons, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int r = 1; r <= k; r++) {
                if (dungeons[i - 1][0] > r) {
                    dp[i][r] = dp[i - 1][r];
                } else {
                    dp[i][r] = Math.max(dp[i - 1][r], 1 + dp[i - 1][r - dungeons[i - 1][1]]);
                }
            }
        }

        return dp[n][k];
    }
}
