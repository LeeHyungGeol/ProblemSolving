import java.util.*;

public class Main {
    static final int MOD = 10_007;
    static int N = 0;
    static int[] dp = new int[1_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[N+1];

        dp[1] = 1 % MOD;
        dp[2] = 1 % MOD;

        for (int i = 3; i <= N; ++i) {
            dp[i] = (dp[i-2] + dp[i-3]) % MOD;
        }

        System.out.println(dp[N-1]);  
    }
}