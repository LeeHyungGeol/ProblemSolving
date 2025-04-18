import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N = 0;
    static long[] dp = new long[1_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD; {
            for (int j = i - 3; j >= 0; j--)
                dp[i] = (dp[i] + dp[j] * 2) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}