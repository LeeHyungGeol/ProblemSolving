import java.util.*;

public class Main {
    private static final int INF = 10_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        final int NEG_INF = -100000000;
        
        // dp[i] = 금액 i를 만들 수 있을 때, 사용한 동전 개수의 최댓값
        // 초기에는 전부 불가능(NEG_INF)로 설정
        int[] dp = new int[m + 1];
        Arrays.fill(dp, NEG_INF);
        
        // 0원을 만드는 데 동전 0개 사용 (가능 상태)
        dp[0] = 0;
        
        // 금액 i가 가능하다면, i+coin도 시도하여 갱신
        for (int i = 0; i <= m; i++) {
            if (dp[i] == NEG_INF) {
                continue; // 아직 i원을 만들 수 없으면 건너뜀
            }
            for (int coin : coins) {
                int next = i + coin;
                if (next <= m) {
                    dp[next] = Math.max(dp[next], dp[i] + 1);
                }
            }
        }
        
        // dp[M]이 NEG_INF면 불가능, 아니면 그 값이 최대 동전 개수
        System.out.println(dp[m] == NEG_INF ? -1 : dp[m]);
    }
}