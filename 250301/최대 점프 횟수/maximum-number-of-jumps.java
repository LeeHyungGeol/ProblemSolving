import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static int[] Arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Arr = new int[N];
        dp = new int[N+1];

        for (int i = 0; i < N; ++i) {
            Arr[i] = sc.nextInt();
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] == -1) continue;
                if (j + Arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            Answer = Math.max(Answer, dp[i]);
        }

        System.out.println(Answer);
    }
}