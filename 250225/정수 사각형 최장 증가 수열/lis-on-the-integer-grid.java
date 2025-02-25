import java.util.*;

public class Main {
    static final int UNUSED = -1;
    private static int N = 0, Answer = 0;
    static int[][] Matrix, dp;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

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

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Answer = Math.max(Answer, findMaxMove(i,j,0));
            }
        }

        System.out.println(Answer);
    }

    private static int findMaxMove(int x, int y, int move) {
        if (dp[x][y] != UNUSED) {
            return dp[x][y];
        }
        // if (cannotMove(x,y)) {
        //     Answer = Math.max(Answer, move);
        //     return dp[x][y] = move;
        // }

        int maxMove = 1;

        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isInRange(nx,ny) && Matrix[nx][ny] > Matrix[x][y]) {
                maxMove = Math.max(maxMove, findMaxMove(nx, ny, move)+1);
            }
        }

        dp[x][y] = maxMove;

        return maxMove;
    }

    private static boolean cannotMove(int x, int y) {
        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!(isInRange(nx,ny) && Matrix[nx][ny] > Matrix[x][y])) {
                return true;
            }
        }

        return false;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}