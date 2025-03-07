import java.util.*;
public class Main {
    public static final int NEG_INF = -1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int totalSum = Arrays.stream(arr).sum();

        // offset : 음수 인덱스를 피하기 위해 totalSum을 offset으로 사용
        int offset = totalSum;
        // dp 배열의 가로 크기는 가능한 diff의 범위: [-totalSum, totalSum]을 0 ~ 2*totalSum으로 매핑
        int dpWidth = 2 * totalSum + 1;
        
        // dp[i][d] : 첫 i개의 원소를 분배하여, (sum(A) - sum(B)) = d - offset일 때,
        // 그룹 A의 합의 최대값을 저장 (불가능한 상태는 NEG_INF)
        int[][] dp = new int[n + 1][dpWidth];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], NEG_INF);
        }
        // 초기 상태: 아직 아무 원소도 사용하지 않았을 때, diff = 0 (즉, d = offset)이고, 그룹 A의 합 = 0
        dp[0][offset] = 0;
        
        // DP 전이: 각 원소를 A, B, C 중 하나에 배분
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            for (int d = 0; d < dpWidth; d++) {
                if (dp[i][d] == NEG_INF) continue; // 해당 상태가 불가능하면 건너뜀
                
                // 1) 원소를 그룹 C에 넣는 경우: A와 B의 합은 변화하지 않음
                dp[i + 1][d] = Math.max(dp[i + 1][d], dp[i][d]);
                
                // 2) 원소를 그룹 A에 넣는 경우:
                // 그룹 A의 합이 val만큼 증가 → 새로운 diff = d + val (d+val <= dpWidth-1)
                if (d + val < dpWidth) {
                    dp[i + 1][d + val] = Math.max(dp[i + 1][d + val], dp[i][d] + val);
                }
                
                // 3) 원소를 그룹 B에 넣는 경우:
                // 그룹 B의 합이 val만큼 증가하므로, diff는 -val 만큼 감소 → 새로운 diff = d - val (d - val >= 0)
                if (d - val >= 0) {
                    dp[i + 1][d - val] = Math.max(dp[i + 1][d - val], dp[i][d]);
                }
            }
        }

        System.out.println(dp[n][offset]);
    }
}