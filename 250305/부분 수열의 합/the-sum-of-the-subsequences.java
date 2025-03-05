import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = m; i >= coin; --i) {
                if (dp[i-coin] != INF) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[m] == INF ? "No" : "Yes");
    }
}