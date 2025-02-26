import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_R = 100;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    // dp[x][y][m]: (0,0)에서 (x,y)까지 도달하는 경로 중, 경로상의 최소값이 m일 때 해당 경로의 최대값의 최솟값
    // 미계산 상태는 -1로 초기화
    public static int[][][] dp = new int[MAX_N][MAX_N][MAX_R + 1];
    
    public static void initializeDP() {
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
    
    // rec(x, y, m)
    // : (0,0)에서 (x,y)까지 도달할 때, 경로상의 최소값이 m인 경우,
    //   그 경로에서의 최대값의 최솟값을 반환 (경로가 없으면 INT_MAX)
    public static int rec(int x, int y, int m) {
        if (x == 0 && y == 0) {
            // 시작점에서는 경로의 최소값이 num[0][0]이어야 함
            return (m == num[0][0]) ? num[0][0] : INT_MAX;
        }
        
        if (dp[x][y][m] != -1) {
            return dp[x][y][m];
        }
        
        int best = INT_MAX;
        // (x,y)로 올 수 있는 두 방향: 위쪽과 왼쪽
        int[] dx = {-1, 0};
        int[] dy = {0, -1};
        for (int d = 0; d < 2; d++) {
            int px = x + dx[d];
            int py = y + dy[d];
            if (px < 0 || py < 0)
                continue;
            // 이전 경로에서의 최소값 p (1 ~ MAX_R)와 현재 셀 num[x][y]를
            // 결합하여 최종 최소값이 m이 되는 경우를 모두 고려
            for (int p = 1; p <= MAX_R; p++) {
                if (Math.min(p, num[x][y]) == m) {
                    int candidate = rec(px, py, p);
                    if (candidate != INT_MAX) {
                        candidate = Math.max(candidate, num[x][y]);
                        best = Math.min(best, candidate);
                    }
                }
            }
        }
        dp[x][y][m] = best;
        return best;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();
        initializeDP();
        
        int ans = INT_MAX;
        // (n-1, n-1)에 도달하는 경로는 경로상 최소값 m에 따라 여러 값이 있을 수 있음.
        // m = 1 ~ MAX_R 까지 각각 rec(n-1, n-1, m)를 호출하여 candidate = (최대값 - m)를 구하고 최솟값을 찾음.
        for (int m = 1; m <= MAX_R; m++) {
            int candidate = rec(n - 1, n - 1, m);
            if (candidate != INT_MAX) {
                ans = Math.min(ans, candidate - m);
            }
        }
        
        System.out.print(ans);
    }
}
