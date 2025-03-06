import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 전체 합
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // dp[i][w] : 처음 i개의 원소로 합 w를 만들 수 있는지 여부
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        
        // 초기화
        dp[0][0] = true; // 아무것도 선택하지 않으면 합 0은 가능
        
        // DP 채우기
        for (int i = 1; i <= n; i++) {
            int val = arr[i - 1]; // i번째 원소 (인덱스 i-1)
            for (int w = 0; w <= totalSum; w++) {
                // 이전 i-1개로 이미 w를 만들 수 있으면 그대로 가능
                if (dp[i - 1][w]) {
                    dp[i][w] = true;
                }
                // val을 추가해서 w를 만들 수 있는 경우
                if (w >= val && dp[i - 1][w - val]) {
                    dp[i][w] = true;
                }
            }
        }
        
        // 각 그룹이 최소 1개 이상 -> A가 전부 가져가는(또는 B가 전부 가져가는) 경우는 제외
        // 즉, w=0 또는 w=totalSum은 부분집합이 전부 비거나 전부인 경우이므로 제외
        
        int minDiff = Integer.MAX_VALUE;
        // totalSum/2까지만 확인하면 됨 (대칭성)
        for (int w = 1; w < totalSum; w++) {
            if (dp[n][w]) {
                int diff = Math.abs((totalSum - w) - w);
                minDiff = Math.min(minDiff, diff);
            }
        }
        
        System.out.println(minDiff);
    }
}