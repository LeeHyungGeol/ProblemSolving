import java.util.*;

public class Main {
    static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[1] = 1;

        for (int i = 2; i <= N; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }    

        System.out.println(dp[N]);
    }
}