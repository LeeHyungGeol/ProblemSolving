import java.util.*;
public class Main {
    static final int U = 0, D = 1, L = 2, R = 3, ASCII = 128, SIZE = 4000, OFFSET = 2000;
    static final Marble IllegalPoint = new Marble(-1,-1,-1,-1,-1);
    
    static int T = 0, N = 0, LastCollisionTime = 0, CurTime = 0;
    static int[] DirMapper = new int[ASCII];
    static int[] DX = {-1,1,0,0};
    static int[] DY = {0,0,-1,1};
    static ArrayList<Marble>[][] Arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        DirMapper['U'] = 0;
        DirMapper['D'] = 1;
        DirMapper['L'] = 2;
        DirMapper['R'] = 3;

        while(T-- > 0) {
            N = scanner.nextInt();

            Arr = new ArrayList[SIZE][SIZE];

            for (int i = 0; i < SIZE; ++i) {
                for (int j = 0; j < SIZE; ++j) {
                    Arr[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int w = scanner.nextInt();
                int dir = DirMapper[scanner.next().charAt(0)];
                int nx = (x*2) + OFFSET;
                int ny = (y*2) + OFFSET;

                Arr[nx][ny].add(new Marble(nx,ny,dir,w,i+1));
            }

            LastCollisionTime = -1;
            for (int t = 1; t <= SIZE; ++t) {
                CurTime = t;
                simulate();
            }

            System.out.println(LastCollisionTime);
        }
    }

    private static void simulate() {
        moveAll();
        removeDuplicatedMarbles();
    }

    private static void moveAll() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (Arr[i][j].isEmpty()) continue;
                Iterator<Marble> it = Arr[i][j].iterator();

                while (it.hasNext()) {
                    Marble m = it.next();
                    m.move();
                    if (m != IllegalPoint) {
                        Arr[m.x][m.y].add(m);
                    }
                    it.remove();
                }
            }
        }
    }

    private static void removeDuplicatedMarbles() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (Arr[i][j].size() >= 2) {
                    LastCollisionTime = CurTime;
                    removeMarble(i, j);
                }
            } 
        }
    }

    private static void removeMarble(int x, int y) {
        Collections.sort(Arr[x][y]);
        Arr[x][y].remove(Arr[x][y].size()-1);   
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
            return 0 <= x && x < SIZE && 0 <= y && y < SIZE;
        }

        private void changePosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Marble other) {
            if (this.number != other.number) {
                return other.number - this.number;
            }
            return other.w - this.w;
        }
    }
}