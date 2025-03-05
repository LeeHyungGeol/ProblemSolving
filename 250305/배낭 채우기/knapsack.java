import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; ++i) {
            int weight = weights[i-1];
            int value = values[i-1];
            for (int w = 1; w <= m; ++w) {
                if (weight <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight]+value);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}