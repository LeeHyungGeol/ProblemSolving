import java.util.*;

public class Main {
    private static int N = 0, M = 0;
    private static int[] DX = {-1,-1,-1,0,0,1,1,1};
    private static int[] DY = {-1,0,1,-1,1,-1,0,1};
    private static int[][] Arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        Arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = sc.nextInt();
            }
        }

        while (M > 0) {
            for (int num = 1; num <= N*N; ++num) {
                Point p = findNum(num);
                move(p.x, p.y);
            }
            --M;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(Arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Point findNum(int num) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Arr[i][j] == num) {
                    return new Point(i,j);
                }
            }
        }

        return null;
    }

    private static void move(int x, int y) {
        Point maxPoint = new Point(0,0);
        int max = -1;

        for (int d = 0; d < 8; ++d) {
            int nx = x + DX[d];
            int ny = y + DY[d];

            if (!isInRange(nx, ny)) continue;
            if (Arr[nx][ny] > max) {
                max = Arr[nx][ny];
                maxPoint = new Point(nx, ny);
            }
        }

        int temp = Arr[x][y];
        Arr[x][y] = Arr[maxPoint.x][maxPoint.y];
        Arr[maxPoint.x][maxPoint.y] = temp;
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