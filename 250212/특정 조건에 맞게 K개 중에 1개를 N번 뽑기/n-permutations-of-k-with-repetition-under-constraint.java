import java.util.*;

public class Main {
    static int K = 0, N = 0, Answer;
    static int[] Arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        Arr = new int[N];

        dfs(0);
    }

    private static void dfs(int size) {
        if (size == N) {
            if (isNotContinuedSameNumberExist()) {
                for (int i = 0; i < N; ++i) {
                    System.out.print(Arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= K; ++i) {
            Arr[size] = i;
            dfs(size+1);
        }
    }

    private static boolean isNotContinuedSameNumberExist() {
        if (N < 3) {
            return true;
        }

        for (int i = 0; i < N; i += 3) {
            if (Arr[i] == Arr[i+1] && Arr[i+1] == Arr[i+2]) {
                return false;
            }
        }

        return true;
    }
}