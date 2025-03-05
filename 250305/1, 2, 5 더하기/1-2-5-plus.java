// 점화식에 따라 dp값 채우기
// dp[i] = dp[i - 2] + dp[i - 3]
import java.util.*;

public class Main {
    static final int MOD = 10_007;
    static int N = 0;
    static int[] dp = new int[1_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[1] = 1 % MOD;
        dp[2] = 2 % MOD;
        dp[3] = 3 % MOD;
        dp[4] = 5 % MOD;
        dp[5] = 9 % MOD;

        for (int i = 6; i <= N; ++i) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-5]) % MOD;
        }

        System.out.println(dp[N]);  
    }
}