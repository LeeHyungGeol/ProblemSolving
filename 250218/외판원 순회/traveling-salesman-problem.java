// backtracking 유형이지만, 플로이드 워셜 알고리즘으로 풀 수 있을 것 같다는 생각이 들었다.
import java.util.*;

public class Main {
    static int N = 0, Answer = Integer.MAX_VALUE;
    static int[][] Matrix;
    static boolean[] Visited;
    static int[] Selected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        Matrix = new int[N][N];
        Visited = new boolean[N];
        Selected = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Matrix[i][j] = scanner.nextInt();
            }
        }

        Visited[0] = true;

        dfs(0,0,0);

        System.out.println(Answer);
    }

    private static void dfs(int depth, int sum, int row) {
        if (depth == N-1) {
            // for (int i = 0; i < N; ++i) {
            //     System.out.print(Selected[i] + " ");
            // }
            // System.out.println(Matrix[row][0]);
            Answer = Math.min(Answer, sum+Matrix[row][0]);
            return;
        }

        for (int col = 0; col < N; ++col) {
            if (Visited[col] || Matrix[row][col] == 0) continue;
            Visited[col] = true;
            Selected[depth] = Matrix[row][col];
            dfs(depth+1, sum + Matrix[row][col], col);
            Visited[col] = false;
        }
    }
}