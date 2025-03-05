import java.util.*;

public class Main {
    private static final int INF = 1_000_000_000;
    static int N = 0, M = 0;
    static int[] Arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        Arr = new int[N];
        dp = new int[M+1];

        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int n : Arr) {
            for (int i = M; i >= n; --i) {
                if (dp[i-n] != INF) {
                    dp[i] = Math.min(dp[i], dp[i-n]+1);
                }
            }
        }

        System.out.println(dp[M] == INF ? -1 : dp[M]);
    }
}