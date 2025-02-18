// backtracking 유형이지만, 플로이드 워셜 알고리즘으로 풀 수 있을 것 같다는 생각이 들었다.
import java.util.*;

public class Main {
    static int N = 0, Answer = Integer.MAX_VALUE;
    static int[][] Matrix;
    static boolean[] Visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        Matrix = new int[N][N];
        Visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Matrix[i][j] = scanner.nextInt();
            }
        }

        dfs(0,0);

        System.out.println(Answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            Answer = Math.min(Answer, sum);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (Visited[i] || i == depth) continue;
            Visited[i] = true;
            dfs(depth+1, sum + Matrix[depth][i]);
            Visited[i] = false;
        }
    }
}