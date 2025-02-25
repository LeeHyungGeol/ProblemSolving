import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_R = 100;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    // memo[i][j][m] : (0,0)에서 (i,j)까지 가면서 경로 상의 최소값이 m일 때, 경로에서의 최대값의 최솟값
    // 아직 계산되지 않은 상태는 -1로 초기화합니다.
    public static int[][][] memo = new int[MAX_N][MAX_N][MAX_R + 1];
    
    public static void initializeMemo() {
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
    }
    
    // rec(i, j, m)
    // (0,0)에서 (i,j)까지 도달했을 때, 경로 상의 최소값이 m인 경우에
    // 경로에서의 최대값의 최솟값을 반환합니다.
    // 만약 해당 경로가 존재하지 않으면 INT_MAX를 반환합니다.
    public static int rec(int i, int j, int m) {
        // 기저 사례: 시작점
        if(i == 0 && j == 0) {
            // (0,0)에서는 경로의 최소값이 num[0][0]이어야 합니다.
            return (m == num[0][0]) ? num[0][0] : INT_MAX;
        }
        
        if(memo[i][j][m] != -1) {
            return memo[i][j][m];
        }
        
        int best = INT_MAX;
        // (i,j)에서 현재 셀의 값 num[i][j]를 포함하면
        // 경로 상의 최소값은 newMin = Math.min(prev, num[i][j])가 되어야 하는데,
        // 이 newMin이 m와 같아야 합니다.
        // 위쪽(i-1,j)에서 내려오는 경우
        if(i > 0) {
            for (int prev = 1; prev <= MAX_R; prev++) {
                if(Math.min(prev, num[i][j]) == m) {
                    int candidate = rec(i - 1, j, prev);
                    if(candidate != INT_MAX) {
                        candidate = Math.max(candidate, num[i][j]);
                        best = Math.min(best, candidate);
                    }
                }
            }
        }
        // 왼쪽(i,j-1)에서 오른쪽으로 오는 경우
        if(j > 0) {
            for (int prev = 1; prev <= MAX_R; prev++) {
                if(Math.min(prev, num[i][j]) == m) {
                    int candidate = rec(i, j - 1, prev);
                    if(candidate != INT_MAX) {
                        candidate = Math.max(candidate, num[i][j]);
                        best = Math.min(best, candidate);
                    }
                }
            }
        }
        
        memo[i][j][m] = best;
        return best;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: n과 n x n 행렬
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();
        
        initializeMemo();
        
        // (n-1, n-1)까지 도달하는 경로에 대해,
        // 경로 상의 최소값이 m일 때의 최대값과의 차이(candidate = rec(n-1,n-1, m) - m)를
        // 모든 m (1 ~ MAX_R) 에 대해 구한 후 최솟값을 답으로 선택합니다.
        int ans = INT_MAX;
        for (int m = 1; m <= MAX_R; m++) {
            int candidate = rec(n - 1, n - 1, m);
            if(candidate != INT_MAX) {
                ans = Math.min(ans, candidate - m);
            }
        }
        
        System.out.print(ans);
    }
}
