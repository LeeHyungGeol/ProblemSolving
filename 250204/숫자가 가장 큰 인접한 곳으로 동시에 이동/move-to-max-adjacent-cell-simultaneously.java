import java.util.*;

public class Main {
    private static int N = 0, M = 0, T = 0;
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};
    private static int[][] Arr;
    private static int[][] Balls;
    private static int[][] NewBalls;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        Arr = new int[N][N];
        Balls = new int[N][N];
        NewBalls = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; ++i) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            Balls[x][y]++;
        }
        
        int answer = 0;
        while (T > 0) {
            answer = moveAll();
            --T;
        }

        System.out.println(answer);
    }

    private static int moveAll() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                NewBalls[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Balls[i][j] == 1) {
                    Balls[i][j] = 0;
                    Point p = move(new Point(i,j));
                    ++NewBalls[p.x][p.y];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (NewBalls[i][j] == 1) {
                    ++Balls[i][j];
                    ++result;
                }
            }
        }

        return result;
    }

    private static Point move(Point p) {
        int max = 0;
        Point result = new Point(0,0);

        for (int d = 0; d < 4; ++d) {
            int nx = p.x + DX[d];
            int ny = p.y + DY[d];

            if (!isInRange(nx,ny)) continue;
            if (Arr[nx][ny] > max) {
                max = Arr[nx][ny];
                result = new Point(nx, ny);
            }
        }

        return result;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}