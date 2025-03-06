import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; ++j) {
                dp[i] = Math.max(dp[i], dp[i - j] + profit[j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}