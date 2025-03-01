import java.util.*;

public class Main {
    static int N = 0, Answer = 1;
    static Line[] Arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Arr = new Line[N];
        dp = new int[N];

        for (int i = 0; i < N; ++i) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            Arr[i] = new Line(l,r);
        }

        Arrays.sort(Arr);
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (Arr[j].r < Arr[i].l) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            Answer = Math.max(Answer, dp[i]);
        }

        System.out.println(Answer);
    }

    static class Line implements Comparable<Line>{
        int l, r;

        public Line(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Line other) {
            if (this.l == other.l) {
                return this.r - other.r;
            }
            return this.l - other.l;
        }
    }
}