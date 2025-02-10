import java.util.*;

public class Main {
    static int N;
    static int BEAUTIFUL_ARRAY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0);
        System.out.println(BEAUTIFUL_ARRAY);
    }

    private static void dfs(int size) {
        if (size >= N) {
            if (size == N) {
                BEAUTIFUL_ARRAY++;
            }
            return;
        }

        for (int i=1; i<=4; i++) {
            dfs(size+i);
        }
    }
}