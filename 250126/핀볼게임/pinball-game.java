import java.util.*;

public class Main {
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    
    private static int N = 0;
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[][] arr = new int[N][N];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int d = DOWN;
        int x = -1;
        for (int col = 0; col < N; ++col) {
            pq.add(simulate(arr, x, col, d));
        }

        d = RIGHT;
        int y = -1;
        for (int row = 0; row < N; ++row) {
            pq.add(simulate(arr, row, y, d));
        }

        d = UP;
        x = N;
        for (int col = 0; col < N; ++col) {
            pq.add(simulate(arr, x, col, d));
        }

        d = LEFT;
        y = N;
        for (int row = 0; row < N; ++row) {
            pq.add(simulate(arr, row, y, d));
        }

        System.out.println(pq.peek());
    }

    private static int simulate(int[][] arr, int x, int y, int d) {
        int result = 0;

        while (true) {
            int nx = x + DX[d];
            int ny = y + DY[d];

            ++result;

            if (!isInRange(nx, ny)) {
                break;
            }

            if (arr[nx][ny] != 0) {
                d = getBarDirection(arr[nx][ny], d);
            }

            x = nx;
            y = ny;
        }

        return result;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int getBarDirection(int bar, int d) {
        if (bar == 1) {
            if (d == RIGHT) {
                return UP;
            } else if (d == DOWN) {
                return LEFT;
            } else if (d == LEFT) {
                return DOWN;
            }
            return RIGHT;
        } else {
            if (d == LEFT) {
                return UP;
            } else if (d == DOWN) {
                return RIGHT;
            } else if (d == RIGHT) {
                return DOWN;
            }
            return LEFT;
        }
    }
}