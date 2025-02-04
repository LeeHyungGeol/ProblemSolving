import java.util.*;

public class Main {
    private static final int U = 0, D = 1, L = 2, R = 3, ASCII = 128;

    private static int[] DirMapper = new int[ASCII];
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};
    private static int[][] Arr;
    private static int[][] NewArr;
    private static int T = 0, N = 0, M = 0;

    private static List<Point> Points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        DirMapper['U'] = 0;
        DirMapper['D'] = 1;
        DirMapper['L'] = 2;
        DirMapper['R'] = 3;

        while (T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            
            Arr = new int[N][N];
            NewArr = new int[N][N];
            Points = new ArrayList<>(); 

            for (int i = 0; i < M; ++i) {
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                String dir = sc.next();

                Points.add(new Point(x,y,DirMapper[dir.charAt(0)]));
            }

            for (int count = 1; count <= 2*N; ++count) {
                moveAll();
            }

            System.out.println(Points.size());
        }
    }

    private static void moveAll() {
        List<Point> toRemove = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Arr[i][j] = 0;
            }
        }

        for (Point p : Points) {
            int nx = p.x + DX[p.dir];
            int ny = p.y + DY[p.dir];

            if (isInRange(nx,ny)) {
                ++Arr[nx][ny];
                p.changePosition(nx,ny,p.dir);
            } else {
                ++Arr[p.x][p.y];
                p.changeDir(getOppositeDirection(p.dir));
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Arr[i][j] > 1) {
                    for (Point p : Points) {
                        if (p.x == i && p.y == j) {
                            toRemove.add(p);
                        }
                    }
                }
            }
        }

        Points.removeAll(toRemove);
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int getOppositeDirection(int dir) {
        if (dir == L) {
            return R;
        } else if (dir == R) {
            return L;
        } else if (dir == U) {
            return D;
        }
        return U;
    }

    static class Point {
        int x, y, dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void changePosition(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void changeDir(int dir) {
            this.dir = dir;
        }
    }
}