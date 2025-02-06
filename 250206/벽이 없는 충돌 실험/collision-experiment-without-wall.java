import java.util.*;
public class Main {
    static final int U = 0, D = 1, L = 2, R = 3, ASCII = 128, SIZE = 4000, OFFSET = 2000, NONE = -1;
    static final Marble IllegalPoint = new Marble(-1,-1,-1,-1,-1);
    
    static int T = 0, N = 0, LastCollisionTime = 0, CurTime = 0;
    static int[] DirMapper = new int[ASCII];
    static int[] DX = {0, 1, -1, 0};
    static int[] DY = {1, 0, 0, -1};
    static int[][] Arr;
    static ArrayList<Marble> Marbles;
    static ArrayList<Marble> TempMarbles;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        DirMapper['U'] = 0;
        DirMapper['R'] = 1;
        DirMapper['L'] = 2;
        DirMapper['D'] = 3;

        Arr = new int[SIZE+1][SIZE+1];

        for (int i = 0; i <= SIZE; ++i) {
            for (int j = 0; j <= SIZE; ++j) {
                Arr[i][j] = NONE;
            }
        }

        while(T-- > 0) {
            N = scanner.nextInt();

            Marbles = new ArrayList<>();
            TempMarbles = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int w = scanner.nextInt();
                int dir = DirMapper[scanner.next().charAt(0)];
                int nx = (x*2) + OFFSET;
                int ny = (y*2) + OFFSET;

                Marbles.add(new Marble(nx,ny,dir,w,i+1));
            }

            LastCollisionTime = -1;
            for (CurTime = 1; CurTime <= SIZE; ++CurTime) {
                simulate();
            }

            System.out.println(LastCollisionTime);
        }
    }

    private static void simulate() {
        moveAll();
    }

    private static void moveAll() {
        for (int i = 0; i < Marbles.size(); ++i) {
            Marble next = Marbles.get(i).move();
            if (next != IllegalPoint) {
                removeDuplicatedMarblesIfExist(next);
            }
        }

        Marbles = (ArrayList<Marble>) TempMarbles.clone();

        initForSimulate();
    }

    private static void removeDuplicatedMarblesIfExist(Marble m) {
        int index = getMarbleIndex(m);

        if (index == NONE) {
            TempMarbles.add(m);
            Arr[m.x][m.y] = TempMarbles.size() - 1;
        } else {
            Marble survivedMarble = collision(m, TempMarbles.get(index));
            TempMarbles.set(index, survivedMarble);
            LastCollisionTime = CurTime;
        }
    }

    private static Marble collision(Marble m1, Marble m2) {
        if (m1.compareTo(m2) < 0) {
            return m1;
        }
        return m2;
    }

    private static int getMarbleIndex(Marble m) {
        return Arr[m.x][m.y];
    }

    private static void initForSimulate() {
        for (Marble m : TempMarbles) {
            Arr[m.x][m.y] = NONE;
        }
        TempMarbles = new ArrayList<>();
    }

    static class Marble implements Comparable<Marble>{
        int x, y, dir, w, number;

        public Marble(int x, int y, int dir, int w, int number) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.w = w;
            this.number = number;
        }

        public Marble move() {
            int nx = this.x + DX[this.dir];
            int ny = this.y + DY[this.dir];

            if (!isInRange(nx, ny)) {
                return IllegalPoint;
            }

            this.x = nx;
            this.y = ny;

            return this;
        }

        private boolean isInRange(int x, int y) {
            return 0 <= x && x <= SIZE && 0 <= y && y <= SIZE;
        }


        @Override
        public int compareTo(Marble other) {
            if (this.w == other.w) {
                return other.number - this.number;
            }
            return other.w - this.w;
        }
    }
}