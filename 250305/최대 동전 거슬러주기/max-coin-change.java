import java.util.*;

public class Main {
    private static final int INF = 10_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        final int NEG_INF = -100000000;
        
        int[] dp = new int[m + 1];
        Arrays.fill(dp, NEG_INF);
        
        dp[0] = 0;
        
        for (int i = 0; i <= m; i++) {
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] != NEG_INF) {
                    dp[i] = Math.max(dp[i], dp[i-coin] + 1);
                }
            }
        }
        
        System.out.println(dp[m] == NEG_INF ? -1 : dp[m]);
    }
}