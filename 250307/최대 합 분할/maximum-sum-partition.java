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

        // dp[i][a][b]:
        //  첫 i개의 원소(인덱스 0..i-1)를 분배하여 A의 합=a, B의 합=b가 되는 것이 가능하면 true
        boolean[][][] dp = new boolean[n + 1][totalSum + 1][totalSum + 1];

        // 초기화: 아무것도 분배하지 않았을 때, A=0,B=0은 가능
        dp[0][0][0] = true;

        // DP 채우기
        for (int i = 1; i <= n; i++) {
            int val = arr[i - 1];  // i번째 원소(인덱스 i-1)
            for (int a = 0; a <= totalSum; a++) {
                for (int b = 0; b <= totalSum; b++) {
                    if (!dp[i - 1][a][b]) continue;
                    
                    // 1) 원소를 C에 넣기 (A,B 합 변화 없음)
                    dp[i][a][b] = true;
                    
                    // 2) 원소를 A에 넣기
                    if (a + val <= totalSum) {
                        dp[i][a + val][b] = true;
                    }
                    
                    // 3) 원소를 B에 넣기
                    if (b + val <= totalSum) {
                        dp[i][a][b + val] = true;
                    }
                }
            }
        }

        // 이제 dp[n][a][b]가 true인 (a,b) 중에서 a=b를 만족하는
        // 가장 큰 a+b = 2a를 찾는다.
        int max2A = -1;  // 2*sum(A)의 최댓값
        for (int a = 0; a <= totalSum; a++) {
            if (dp[n][a][a]) {
                // a=b
                max2A = Math.max(max2A, 2*a);
            }
        }

        System.out.println(max2A/2);
    }
}