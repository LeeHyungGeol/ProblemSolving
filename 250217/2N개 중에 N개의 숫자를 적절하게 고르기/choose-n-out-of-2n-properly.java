import java.util.*;

public class Main {
    static int N = 0, Answer = Integer.MAX_VALUE;
    static int[] Arr;
    static boolean[] Selected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        
        Arr = new int[2*N];
        Selected = new boolean[2*N];
        
        for (int i = 0; i < 2*N; i++) {
            Arr[i] = scanner.nextInt();
        }

        dfs(0,0);

        System.out.println(Answer);
    }

    private static void dfs(int start, int count) {
        if (count == N) {
            Answer = Math.min(Answer, calculate());
            return;
        }

        for (int i = start; i < 2*N; ++i) {
            if (Selected[i]) continue;
            Selected[i] = true;
            dfs(i, count+1);
            Selected[i] = false;
        }
    }

    private static int calculate() {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < 2*N; ++i) {
            if (Selected[i]) {
                sum1 += Arr[i];
            } else {
                sum2 += Arr[i];
            }
        }

        return Math.abs(sum1-sum2);
    }
}