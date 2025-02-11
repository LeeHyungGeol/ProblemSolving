import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static int[][] Arr;
    static ArrayList<Point> Bombs = new ArrayList<>();
    static int[] Cases;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        
        Arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = scanner.nextInt();
                if (Arr[i][j] == 1) {
                    Bombs.add(new Point(i,j));
                }
            }
        }

        Cases = new int[Bombs.size()];

        dfs(0);

        System.out.println(Answer);
    }

    private static void dfs(int size) {
        if (size == Bombs.size()) {
            countBombs();
            return;
        }

        for (int i = 0; i < 3; ++i) {
            Cases[size] = i;
            dfs(size + 1);
            Cases[size] = 0;
        }
    }

    private static void countBombs() {
        int[][] temp = new int[N][N];
        int[] dx1 = {-2,-1,0,1,2};
        int[] dy1 = {0,0,0,0,0};

        int[] dx2 = {-1,1,0,0,0};
        int[] dy2 = {0,0,0,-1,1};

        int[] dx3 = {-1,-1,0,1,1};
        int[] dy3 = {-1,1,0,-1,1};

        for (int i = 0; i < Bombs.size(); ++i) {
            Point p = Bombs.get(i);

            for (int d = 0; d < 5; ++d) {
                int nx;
                int ny;

                if (Cases[i] == 0) {
                    nx = p.x + dx1[d];
                    ny = p.y + dy1[d];
                } else if(Cases[i] == 1) {
                    nx = p.x + dx2[d];
                    ny = p.y + dy2[d];
                } else {
                    nx = p.x + dx3[d];
                    ny = p.y + dy3[d];
                }

                if (!isInRange(nx, ny)) continue;
                temp[nx][ny] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (temp[i][j] == 1) {
                    ++count;
                }
            }
        }

        Answer = Math.max(Answer, count);
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