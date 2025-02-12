import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] ladder;
    private static int[] res;
    private static int ans;
    private static List<int[]> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로줄 수
        M = Integer.parseInt(st.nextToken()); // 가로줄 수
        ladder = new int[16][N + 1];
        ans = M;

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            lines.add(new int[]{a, b});
            ladder[b][a] = 1; // b번째 세로의 a번 라인에서 a+1로 가는 걸 나타냄
            ladder[b][a + 1] = -1; // b번째 세로의 a+1번 라인에서 a로 가는 걸 나타냄
        }

        res = newRes();

        go(0, 0);
        System.out.println(ans);
    }

    private static int[] newRes() {
        int[] res = new int[N + 1];
        int col, row;
        for (int i = 1; i <= N; i++) {
            col = i;
            row = 15;
            while (row > 0) {
                if (ladder[row][col] != 0) {
                    col += ladder[row][col];
                }
                row--;
            }
            res[i] = col;
        }
        return res;
    }

    private static void go(int depth, int cnt) {
        if (depth == M) {
            int[] tmp = newRes();
            if (sameResWith(tmp)) {
                ans = Math.min(ans, M - cnt);
            }
            return;
        }

        int[] line = lines.get(depth);
        int a = line[0];
        int b = line[1];
        ladder[b][a] = 0;
        ladder[b][a + 1] = 0;
        go(depth + 1, cnt+1);
        ladder[b][a] = 1;
        ladder[b][a + 1] = -1;
        go(depth + 1, cnt);

    }

    private static boolean sameResWith(int[] tmp) {
        for (int i = 1; i <= (N / 2) + 1; i++) {
            if (tmp[i] != res[i] || tmp[N - i + 1] != res[N - i + 1]) {
                return false;
            }
        }
        return true;
    }
}