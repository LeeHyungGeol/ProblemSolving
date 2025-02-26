// import java.util.Scanner;
// import java.util.Arrays;

// public class Main {
//     public static final int INT_MAX = Integer.MAX_VALUE;
//     public static final int MAX_R = 100;
//     public static final int MAX_N = 100;
    
//     public static int n;
//     public static int[][] num = new int[MAX_N][MAX_N];
//     // memo[i][j][m] : (0,0)에서 (i,j)까지 가면서 경로 상의 최소값이 m일 때, 경로에서의 최대값의 최솟값
//     // 아직 계산되지 않은 상태는 -1로 초기화합니다.
//     public static int[][][] memo = new int[MAX_N][MAX_N][MAX_R + 1];
    
//     public static void initializeMemo() {
//         for (int i = 0; i < MAX_N; i++) {
//             for (int j = 0; j < MAX_N; j++) {
//                 Arrays.fill(memo[i][j], -1);
//             }
//         }
//     }
    
//     // rec(i, j, m)
//     // (0,0)에서 (i,j)까지 도달했을 때, 경로 상의 최소값이 m인 경우에
//     // 경로에서의 최대값의 최솟값을 반환합니다.
//     // 만약 해당 경로가 존재하지 않으면 INT_MAX를 반환합니다.
//     public static int rec(int i, int j, int m) {
//         // 기저 사례: 시작점
//         if(i == 0 && j == 0) {
//             // (0,0)에서는 경로의 최소값이 num[0][0]이어야 합니다.
//             return (m == num[0][0]) ? num[0][0] : INT_MAX;
//         }
        
//         if(memo[i][j][m] != -1) {
//             return memo[i][j][m];
//         }
        
//         int best = INT_MAX;
//         // (i,j)에서 현재 셀의 값 num[i][j]를 포함하면
//         // 경로 상의 최소값은 newMin = Math.min(prev, num[i][j])가 되어야 하는데,
//         // 이 newMin이 m와 같아야 합니다.
//         // 위쪽(i-1,j)에서 내려오는 경우
//         if(i > 0) {
//             for (int prev = 1; prev <= MAX_R; prev++) {
//                 if(Math.min(prev, num[i][j]) == m) {
//                     int candidate = rec(i - 1, j, prev);
//                     if(candidate != INT_MAX) {
//                         candidate = Math.max(candidate, num[i][j]);
//                         best = Math.min(best, candidate);
//                     }
//                 }
//             }
//         }
//         // 왼쪽(i,j-1)에서 오른쪽으로 오는 경우
//         if(j > 0) {
//             for (int prev = 1; prev <= MAX_R; prev++) {
//                 if(Math.min(prev, num[i][j]) == m) {
//                     int candidate = rec(i, j - 1, prev);
//                     if(candidate != INT_MAX) {
//                         candidate = Math.max(candidate, num[i][j]);
//                         best = Math.min(best, candidate);
//                     }
//                 }
//             }
//         }
        
//         memo[i][j][m] = best;
//         return best;
//     }
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         // 입력: n과 n x n 행렬
//         n = sc.nextInt();
//         for(int i = 0; i < n; i++)
//             for(int j = 0; j < n; j++)
//                 num[i][j] = sc.nextInt();
        
//         initializeMemo();
        
//         // (n-1, n-1)까지 도달하는 경로에 대해,
//         // 경로 상의 최소값이 m일 때의 최대값과의 차이(candidate = rec(n-1,n-1, m) - m)를
//         // 모든 m (1 ~ MAX_R) 에 대해 구한 후 최솟값을 답으로 선택합니다.
//         int ans = INT_MAX;
//         for (int m = 1; m <= MAX_R; m++) {
//             int candidate = rec(n - 1, n - 1, m);
//             if(candidate != INT_MAX) {
//                 ans = Math.min(ans, candidate - m);
//             }
//         }
        
//         System.out.print(ans);
//     }
// }
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    
    // (x,y, currMin, currMax) 상태에 대해 남은 경로에서 만들 수 있는 최소 (max - min) 값을 저장합니다.
    public static HashMap<String, Integer> memo = new HashMap<>();
    
    // rec(x, y, currMin, currMax)
    // (0,0)에서 시작해 (x,y)까지 진행했을 때, 현재까지 경로에 포함된 최소값과 최대값이 각각 currMin, currMax일 때
    // (x,y)부터 (n-1, n-1)까지 진행하여 얻을 수 있는 (최종 max - 최종 min)의 최솟값을 반환합니다.
    public static int rec(int x, int y, int currMin, int currMax) {
        // 현재 셀의 값을 반영하여 상태 업데이트
        currMin = Math.min(currMin, num[x][y]);
        currMax = Math.max(currMax, num[x][y]);
        
        // 도착지에 도달한 경우: 차이를 반환
        if(x == n - 1 && y == n - 1) {
            return currMax - currMin;
        }
        
        // 메모이제이션 키 (x,y,currMin,currMax)
        String key = x + "," + y + "," + currMin + "," + currMax;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int ans = INT_MAX;
        // 아래(1,0)와 오른쪽(0,1)으로 이동하는 dx, dy 배열
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < n && ny < n) {
                ans = Math.min(ans, rec(nx, ny, currMin, currMax));
            }
        }
        memo.put(key, ans);
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: n과 n x n 행렬
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                num[i][j] = sc.nextInt();
            }
        }
        // 시작점 (0,0)에서는 초기 최소, 최대 값 모두 num[0][0]입니다.
        int result = rec(0, 0, num[0][0], num[0][0]);
        System.out.print(result);
    }
}
