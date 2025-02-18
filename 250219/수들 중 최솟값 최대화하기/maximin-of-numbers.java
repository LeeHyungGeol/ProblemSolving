import java.util.*;

public class Main {
    static int N = 0, Answer = -1;
    static int[][] Matrix;
    static int[] Selected;
    static boolean[] Visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Visited = new boolean[N];
        Selected = new int[N];
        Matrix = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Matrix[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(Answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int min = 10001;
            for (int i = 0; i < N; ++i) {
                min = Math.min(min, Selected[i]);
            }

            Answer = Math.max(Answer, min);
            return;
        }

        for (int col = 0; col < N; ++col) {
            if (Visited[col]) continue;
            Visited[col] = true;
            Selected[depth] = Matrix[depth][col];
            dfs(depth+1);
            Visited[col] = false;
            Selected[depth] = 0;
        }
    }
}