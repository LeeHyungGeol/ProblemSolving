import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_R = 100;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    // dp[x][y][m]: (x,y)에 도달했을 때, 경로 상의 최소값이 m일 경우 현재까지 경로에서 기록된 currentMax의 최소값.
    // 아직 방문하지 않은 상태는 -1로 초기화합니다.
    public static int[][][] dp = new int[MAX_N][MAX_N][MAX_R + 1];
    
    public static void initializeDP() {
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
    
    /**
     * DFS로 (0,0)에서 (n-1, n-1)까지 경로를 탐색합니다.
     * @param x 현재 행 좌표
     * @param y 현재 열 좌표
     * @param m 현재까지 경로에서의 최소값
     * @param currMax 현재까지 경로에서의 최대값
     * @return (현재 경로에서 최종적으로 도달하는 값들 중 (최대 - 최소)의 차이가 최소가 되는 값)
     */
    public static int dfs(int x, int y, int m, int currMax) {
        // 도착지에 도달했다면, 현재까지의 차이를 반환합니다.
        if (x == n - 1 && y == n - 1) {
            return currMax - m;
        }
        
        // 이미 (x,y)에서 같은 m 값으로 더 낮은(또는 같은) currMax로 방문한 적이 있다면,
        // 더 큰 currMax로 도달한 경우는 개선되지 않으므로 가지치기합니다.
        if (dp[x][y][m] != -1 && dp[x][y][m] <= currMax) {
            return INT_MAX;
        }
        dp[x][y][m] = currMax;
        
        int ans = INT_MAX;
        // 오른쪽과 아래로만 이동하도록 dx, dy 배열 사용
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < n && ny < n) {
                int newM = Math.min(m, num[nx][ny]);
                int newMax = Math.max(currMax, num[nx][ny]);
                ans = Math.min(ans, dfs(nx, ny, newM, newMax));
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n과 n x n 행렬 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                num[i][j] = sc.nextInt();
            }
        }
        initializeDP();
        // 시작점 (0,0): 초기 최소, 최대값 모두 num[0][0]
        int result = dfs(0, 0, num[0][0], num[0][0]);
        System.out.print(result);
    }
}
