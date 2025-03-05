import java.util.*;

public class Main {
    public static int N = 0, Amount = 0, Answer = Integer.MAX_VALUE;
    public static int[] coins;
    public static int[] dp;

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Amount = sc.nextInt();

        coins = new int[N];
        dp = new int[Amount+1];

        for (int i = 0; i < N; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.fill(dp, Amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= Amount; ++i) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        System.out.println(dp[Amount] > Amount ? -1 : dp[Amount]);
    }   
}