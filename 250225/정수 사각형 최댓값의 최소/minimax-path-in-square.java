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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Matrix[i][j] = sc.nextInt();
                dp[i][j] = UNUSED;
            }
        }

        System.out.println(findMinInMax(0,0));
    }

    private static int findMinInMax(int x, int y) {
        if (dp[x][y] != UNUSED) {
            return dp[x][y];
        }
        if (x == N-1 && y == N-1) {
            return dp[x][y] = Matrix[x][y];
        }

        int[] dx = {1,0};
        int[] dy = {0,1};
        int minValue = 1_000_001;

        for (int d = 0; d < 2; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isInRange(nx, ny)) {
                minValue = Math.min(minValue, Math.max(Matrix[x][y], findMinInMax(nx, ny)));
            }
        }

        return dp[x][y] = minValue;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}