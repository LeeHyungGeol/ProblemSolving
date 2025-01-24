import java.util.*;

public class Main {
    private static final int ASCII = 128;
    private static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

    private static int[] DirMapper;
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,1,-1};
    private static int N = 0, M = 0, K = 0;

    private static Point Head = new Point(0,0);

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        List<Point> apples = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            apples.add(new Point(x, y));
        }

        List<String[]> moves = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String d = sc.next();
            int p = sc.nextInt();
            moves.add(new String[]{d, String.valueOf(p)});
        }

        sc.close();
        
        int[][] arr = new int[N][N];
        DirMapper = new int[ASCII];
        DirMapper['U'] = 0;
        DirMapper['D'] = 1;
        DirMapper['R'] = 2;
        DirMapper['L'] = 3;

        for (Point apple : apples) {
            arr[apple.x][apple.y] = 1;
        }

        int answer = 0;
        List<Point> bodies = new ArrayList<>();

        for (String[] move : moves) {
            int d = DirMapper[move[0].charAt(0)];
            int p = Integer.parseInt(move[1]);

            int nx = 0, ny = 0;
            boolean isEndOfGame = false;

            for (int step = 0; step < p; ++step) {
                Point headMove = new Point(Head.x + DX[d], Head.y + DY[d]);

                // System.out.println("x: "+ headMove.x+", y: "+headMove.y);

                // for (Point point : bodies) {
                //     System.out.println("bodyX: "+ point.x+", bodyY: "+point.y);
                // }

                ++answer;

                if (!isInRange(headMove.x, headMove.y) || bodies.contains(headMove)) {
                    isEndOfGame = true;
                    break;
                }

                if (arr[headMove.x][headMove.y] == 1) {
                    bodies.add(0, new Point(Head.x, Head.y));
                    Head.x = headMove.x;
                    Head.y = headMove.y;
                    arr[headMove.x][headMove.y] = 0;
                    continue;
                }

                bodies.add(0, new Point(Head.x, Head.y));
                bodies.remove(bodies.size()-1);
                Head.x = headMove.x;
                Head.y = headMove.y;
            }

            if (isEndOfGame) {
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    }
}