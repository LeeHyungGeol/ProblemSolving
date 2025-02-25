import java.util.*;

public class Main {
    static final int INF = 99999999;  // 매우 큰 값
    static int N;
    static int[][] Matrix;
    // dp[i][j][k]: (1,1)에서 (i,j)에 도달하는 경로 중, "경로상 모든 값 >= k"를 만족할 때,
    // 경로에 등장하는 값들의 최대값 중 최소가 되는 값
    static int[][][] dp; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        Matrix = new int[N+1][N+1];  // 1-based 인덱스
        dp = new int[N+1][N+1][101]; // k: 1..100
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Matrix[i][j] = sc.nextInt();
                // dp 초기화
                Arrays.fill(dp[i][j], INF);
            }
        }
        
        // 최종 답을 구하기 위한 변수
        int ans = INF;
        
        // 모든 k(경로 최소값) 시도
        for (int k = 1; k <= 100; k++) {
            // dp 테이블을 k마다 다시 초기화해야 함
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    Arrays.fill(dp[i][j], INF);
                }
            }
            int val = rec(N, N, k);  // (N,N)에서의 "최소가능 max"
            if (val != INF) {
                ans = Math.min(ans, val - k);
            }
        }
        
        System.out.println(ans);
    }
    
    // 탑다운 재귀 함수:
    // (i,j)에 도달하는 경로 중, 경로상의 모든 값 >= k 인 경우만 고려,
    // 그러한 경로에서 "경로상의 최대값"의 최솟값을 구한다.
    private static int rec(int i, int j, int k) {
        // (i,j) 칸이 k보다 작은 값이면 경로 불가능
        if (Matrix[i][j] < k) {
            return INF;
        }
        
        // 시작점(1,1)에 도달
        if (i == 1 && j == 1) {
            // (1,1)이 k 미만이면 위에서 걸러짐, 아니면 자기 값이 경로 max
            return Matrix[1][1];
        }
        
        // 이미 계산된 상태라면 반환
        if (dp[i][j][k] != INF) {
            return dp[i][j][k];
        }
        
        int candidate = INF;
        
        // 위( i-1, j )에서 오는 경로
        if (i > 1) {
            int up = rec(i-1, j, k);
            if (up != INF) {
                // 현재 칸값과 up 중 큰 값이 경로의 max
                candidate = Math.min(candidate, Math.max(up, Matrix[i][j]));
            }
        }
        
        // 왼쪽( i, j-1 )에서 오는 경로
        if (j > 1) {
            int left = rec(i, j-1, k);
            if (left != INF) {
                candidate = Math.min(candidate, Math.max(left, Matrix[i][j]));
            }
        }
        
        dp[i][j][k] = candidate;
        return candidate;
    }
}
