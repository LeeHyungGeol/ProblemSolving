import java.util.*;

public class Main {
    static int N = 0, M = 0;
    static int[][] Matrix, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Matrix = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; ++i) 
            for (int j = 0; j < M; ++j) {
                Matrix[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }

        System.out.println(findMaxMove(0,0));
    }

    private static int findMaxMove(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int maxMove = 1;

        for (int nx = x+1; nx < N; ++nx) {
            for (int ny = y+1; ny < M; ++ny) {
                if (isInRange(nx, ny) && Matrix[nx][ny] > Matrix[x][y]) {
                    maxMove = Math.max(maxMove, findMaxMove(nx,ny) + 1);
                }
            }
        }

        dp[x][y] = maxMove;

        return maxMove;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}