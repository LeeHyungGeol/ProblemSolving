import java.util.*;

public class Main {
    static final int MOD = 10_007;
    static int N = 0;
    static int[] dp = new int[1_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; ++i) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}