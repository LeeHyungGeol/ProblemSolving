import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];

        for (int w = 1; w <= m; ++w) {
            for (int i = 0; i < n; ++i) {
                if (weight[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w-weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[m]);
    }
}