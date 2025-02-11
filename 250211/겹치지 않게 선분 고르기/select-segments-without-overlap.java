import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static ArrayList<Line> Lines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            Lines.add(new Line(l,r));
        }

        Collections.sort(Lines);

        int[] selected = new int[Lines.size()];

        dfs(selected, 0);

        System.out.println(Answer);
    }

    private static void dfs(int[] selected, int size) {
        if (size == Lines.size()) {

            // for (int b : selected) {
            //     System.out.print(b + " ");
            // }
            // System.out.println();

            int count = 0;
            int maxR = 0;
            for (int i = 0; i < Lines.size(); ++i) {
                Line l = Lines.get(i);

                if (selected[i] == 1) {
                    if (l.l > maxR) {
                        ++count;
                    } 
                    maxR = l.r;
                }
            }

            Answer = Math.max(Answer, count);
            return;
        }

        for (int i = 0; i < 2; ++i) {
            selected[size] = i;
            dfs(selected, size+1);
            selected[size] = 0;
        }
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