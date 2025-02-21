import java.util.*;

public class Main {
    static final int UNUSED = -1;
    static int N = 0;
    static int[][] Matrix, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Matrix = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Matrix[i][j] = sc.nextInt();
                dp[i][j] = UNUSED;
            }
        }

        System.out.println(findMinSum(0, N-1));
    }

    private static int findMinSum(int x, int y) {
        if (dp[x][y] != UNUSED) {
            return dp[x][y];
        }
        if (x == N-1 && y == 0) {
            return dp[N-1][0] = Matrix[N-1][0];
        }

        int[] dx = {1,0};        
        int[] dy = {0,-1};

        int sum = Integer.MAX_VALUE;
        for (int d = 0; d < 2; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isInRange(nx, ny)) continue;
            sum = Math.min(sum, Matrix[x][y] + findMinSum(nx, ny));
        }

        dp[x][y] = sum;

        return sum;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
