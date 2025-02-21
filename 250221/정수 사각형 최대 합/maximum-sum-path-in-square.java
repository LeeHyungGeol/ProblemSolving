import java.util.*;

public class Main {
    static int N = 0;
    static long[][] Matrix, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Matrix = new long[N+1][N+1];
        dp = new long[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Matrix[i][j] = sc.nextLong();
            }
        }

        dp[0][0] = Matrix[0][0];

        for (int i = 1; i < N; ++i) {
            dp[i][0] = dp[i-1][0] + Matrix[i][0];
        }

        for (int j = 1; j < N; ++j) {
            dp[0][j] = dp[0][j-1] + Matrix[0][j];
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < N; ++j) {
                dp[i][j] = Math.max(dp[i][j-1] + Matrix[i][j], dp[i-1][j] + Matrix[i][j]);
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}