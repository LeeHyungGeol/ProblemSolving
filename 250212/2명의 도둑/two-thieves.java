import java.util.*;

public class Main {
    static int N = 0, M = 0, C = 0, Answer = 0, MaxWeight = 0;
    static int[][] Arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        M = scanner.nextInt();
        C = scanner.nextInt();
        
        Arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = scanner.nextInt();
            }
        }

        int[] selected = new int[2];

        dfs(selected, 0);

        System.out.println(Answer);
    }

    private static void dfs(int[] selected, int size) {
        if (size == 2) {
            if (possible(selected)) {
                Answer = Math.max(Answer, countMaxWeight(selected[0]/N, selected[0]%N)+countMaxWeight(selected[1]/N, selected[1]%N));
            }
            return;
        }

        for (int i = 0; i < N*N; ++i) {
            selected[size] = i;
            dfs(selected, size+1);
            selected[size] = -1;
        }
    }
    
    private static boolean possible(int[] selected) {
        if (selected[0] == selected[1]) {
            return false;
        }

        Point thief1 = new Point(selected[0]/N, selected[0]%N);
        int maxTheif1YSize = thief1.y + M-1;
        Point thief2 = new Point(selected[1]/N, selected[1]%N);
        int maxTheif2YSize = thief2.y + M-1;

        if (!isInRange(thief1.x, maxTheif1YSize)) {
            return false;
        }
        if (!isInRange(thief2.x, maxTheif2YSize)) {
            return false;
        }

        if (isSameRow(thief1.x, thief2.x)) {
            if (thief1.y < thief2.y && thief2.y <= maxTheif1YSize) {
                return false;
            }
            if (thief2.y < thief1.y && thief1.y <= maxTheif2YSize) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSameRow(int row1, int row2) {
        return row1 == row2;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int countMaxWeight(int x, int y) {
        MaxWeight = 0;       

        int[] arr = new int[M];
        for (int i = 0; i < M; ++i) {
            int ny = y + i;
            arr[i] = Arr[x][ny];
        }

        countWeight(arr, 0, 0, 0);

        return MaxWeight;
    }

    private static void countWeight(int[] arr, int sum, int max, int size) {
        if (size == M) {
            if (sum <= C) {
                MaxWeight = Math.max(MaxWeight, max);
            }
            return;
        }

        countWeight(arr, sum, max, size+1);
        countWeight(arr, sum+arr[size], max+(arr[size]*arr[size]), size+1);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}