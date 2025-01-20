import java.util.*;

public class Main {
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt()-1;

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();

        N = n;

        List<Point> block = new ArrayList<>();
        for (int col = k; col <= k+m-1; ++col) {
            block.add(new Point(-1, col));
        }

        while (true) {
            boolean isReached = false;

            for (Point p : block) {
                int nx = p.x + 1;
                int ny = p.y;

                if (arr[nx][ny] == 0) {
                    p.x = nx;
                    p.y = ny;
                } else {
                    isReached = true;
                    break;
                }
            }

            if (isReached) {
                for (Point p : block) {
                    arr[p.x][p.y] = 1;
                }
                break;
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}