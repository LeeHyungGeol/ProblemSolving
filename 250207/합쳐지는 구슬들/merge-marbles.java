import java.util.*;

public class Main {
    static final int U = 0, D = 1, L = 2, R = 3, ASCII = 128;

    static int[] DirMapper = new int[ASCII];
    static int[] DX = {-1,1,0,0};
    static int[] DY = {0,0,-1,1};
    static int[][] Arr;
    static int N = 0, M = 0, T = 0, MaxMarbleWeight = 0;

    private static List<Marble> Marbles;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        T = scanner.nextInt(); 

        DirMapper['U'] = 0;
        DirMapper['D'] = 1;
        DirMapper['L'] = 2;
        DirMapper['R'] = 3;

        Arr = new int[N][N];
        Marbles = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;  
            char dir = scanner.next().charAt(0);
            int w = scanner.nextInt();    
            Marbles.add(new Marble(x,y, DirMapper[dir], w, i+1));
            Arr[x][y]++;
        }

        while(T-- > 0) {
            moveAll();
            mergeDuplicatedMarblesIfExist();
        }

        System.out.println(Marbles.size() + " " + MaxMarbleWeight);
    }

    private static void moveAll() {
        for (Marble m : Marbles) {
            Arr[m.x][m.y]--;
            m.setNextPosition();
            Arr[m.x][m.y]++;
        }
    }

    private static void mergeDuplicatedMarblesIfExist() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Arr[i][j] > 1) {
                    mergeDuplicatedMarbles(i, j);
                }
            }
        }
    }

    private static void mergeDuplicatedMarbles(int x, int y) {
        Iterator<Marble> it = Marbles.iterator();
        Marble MaxNumMarble = new Marble(0,0,0,0,0);
        int weightSum = 0;

        while(it.hasNext()) {
            Marble m = it.next();

            if (m.x == x && m.y == y) {
                weightSum += m.w;
                if (m.num > MaxNumMarble.num) {
                    MaxNumMarble = new Marble(m.x, m.y, m.dir, m.w, m.num);
                }
                it.remove();
            }
        }

        Marbles.add(new Marble(MaxNumMarble.x, MaxNumMarble.y, MaxNumMarble.dir, weightSum, MaxNumMarble.num));
        MaxMarbleWeight = Math.max(MaxMarbleWeight, weightSum);
    }

    static class Marble {
        int x, y, dir, w, num;

        public Marble(int x, int y, int dir, int w, int num) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.w = w;
            this.num = num;
        }

        public void setNextPosition() {
            int nx = this.x + DX[this.dir];
            int ny = this.y + DY[this.dir];

            if (isInRange(nx, ny)) {
                changePosition(nx, ny);
            } else {
                changeDir(this.dir);
            }
        }

        private boolean isInRange(int x, int y) {
            return 0 <= x && x < N && 0 <= y && y < N;
        }

        private void changePosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private void changeDir(int dir) {
            this.dir = oppositeDirection(dir);
        }

        private int oppositeDirection(int dir) {
            if (dir == L) {
                return R;
            } else if (dir == R) {
                return L;
            } else if (dir == U) {
                return D;
            }
            return U;
        }
    }
}