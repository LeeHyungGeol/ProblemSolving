import java.util.*;

public class Main {
    static int N = 0, M = 0, Answer = -1;
    static int[] Arr;
    static boolean[] Visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Arr = new int[N];
        for (int i = 0; i < N; ++i) {
            Arr[i] = sc.nextInt();
        }

        Visited = new boolean[N];

        dfs(0,0);

        System.out.println(Answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            Answer = Math.max(Answer, calculate());
            return;
        }

        for (int i = start; i < N; ++i) {
            if (Visited[i]) continue;
            Visited[i] = true;
            dfs(i, depth+1);
            Visited[i] = false;
        }
    }

    private static int calculate() {
        int result = 0;
        
        for (int i = 0; i < N; ++i) {
            if (Visited[i]) {
                if (result == 0) {
                    result += Arr[i];
                } else {
                    result ^= Arr[i];
                }
            }
        }
        return result;
    }
}