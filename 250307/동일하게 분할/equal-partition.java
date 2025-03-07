import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int totalSum = Arrays.stream(arr).sum();

        boolean[][] dp = new boolean[n+1][totalSum+1];
        dp[0][0] = true;

        for (int i = 1; i <= n; ++i) {
            int val = arr[i-1];
            for (int s = 0; s <= totalSum; ++s) {
                if (dp[i-1][s]) {
                    dp[i][s] = true;
                }
                if (s >= val && dp[i-1][s-val]) {
                    dp[i][s] = true;
                }
            }
        }

        String answer = "No";
        for (int s = 1; s < totalSum; ++s) {
            if (dp[n][s] && Math.abs((totalSum-s) - s) == 0) {
                answer = "Yes";
                break;
            }
        }

        System.out.println(answer);
    }
}