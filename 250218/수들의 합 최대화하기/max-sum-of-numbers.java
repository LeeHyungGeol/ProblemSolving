import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static int[][] Arr;
    static boolean[] VisitedRow, VisitedCol;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        Arr = new int[N][N];
        VisitedRow = new boolean[N];
        VisitedCol = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = scanner.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(Answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            Answer = Math.max(Answer, sum);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (VisitedRow[i]) continue;
            VisitedRow[i] = true;
            for (int j = 0; j < N; ++j) {
                if (VisitedCol[j]) continue;
                VisitedCol[j] = true;
                dfs(depth+1, sum+Arr[i][j]);
                VisitedCol[j] = false;
            }
            VisitedRow[i] = false;
        }
    }
}