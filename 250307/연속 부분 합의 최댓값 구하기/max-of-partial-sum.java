import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // dp[i] : i에서 끝나는 연속 부분 수열의 최대 합
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        int answer = dp[0]; // 최대값 초기화
        
        for (int i = 1; i < n; i++) {
            // i번째 원소를 단독으로 시작 vs 이전 dp에 이어붙이기
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            // 전체 최대값 갱신
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}