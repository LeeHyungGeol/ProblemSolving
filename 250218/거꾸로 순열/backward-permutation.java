import java.util.*;

public class Main {
    static int N = 0;
    static int[] Arr;
    static boolean[] Visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Arr = new int[N];
        Visited = new boolean[N];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; ++i) {
                System.out.print(Arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (Visited[i]) continue;
            Visited[i] = true;
            Arr[depth] = N-i;
            dfs(depth+1);
            Visited[i] = false;
            Arr[depth] = 0;
        }
    }
}
