import java.util.*;
import java.io.*;

public class Main {
    static final int U = 0, D = 1, L = 2, R = 3, ASCII = 128;

    static int[] DirMapper = new int[ASCII];
    static int[] DX = {-1,1,0,0};
    static int[] DY = {0,0,-1,1};
    static int[][] Arr;
    static int N = 0, M = 0, T = 0, K = 0;

    private static List<Marble> Marbles;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        M = scanner.nextInt();
        T = scanner.nextInt();
        K = scanner.nextInt();
        DirMapper['U'] = 0;
        DirMapper['D'] = 1;
        DirMapper['L'] = 2;
        DirMapper['R'] = 3;
        
        Arr = new int[N][N];
        Marbles = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt()-1;         
            int y = scanner.nextInt()-1;           
            int direction = DirMapper[scanner.next().charAt(0)]; 
            int speed = scanner.nextInt();      
            Marbles.add(new Marble(x,y, direction, speed, i+1));
            Arr[x][y]++;
        }

        while(T-- > 0) {
            moveAll();
            removeDuplicateMarbles();
        }

        System.out.println(Marbles.size());
    }

    private static void moveAll() {
        for (Marble m : Marbles) {
            Arr[m.x][m.y]--;
            m.setNextPosition();
            Arr[m.x][m.y]++;
        }
    }

    private static void removeDuplicateMarbles() {
        Collections.sort(Marbles);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Arr[i][j] > K) {
                    removeMarbles(i,j);   
                }
            }
        }
    }

    private static void removeMarbles(int x, int y) {
        Iterator<Marble> it = Marbles.iterator();
        int count = 0;
        boolean isToRemove = false;

        while(it.hasNext()) {
            Marble m = it.next();

            if (m.x == x && m.y == y) {
                ++count;
                if (count > K) {
                    isToRemove = true;
                }
                if (isToRemove) {
                    Arr[m.x][m.y]--;
                    it.remove();
                }
            }
        }
    }

    static class Marble implements Comparable<Marble>{
        int x, y, dir, speed, number;

        public Marble(int x, int y, int dir, int speed, int number) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.speed = speed;
            this.number = number;
        }

        public void setNextPosition() {
            for (int count = 0; count < this.speed; ++count) {
                int nx = this.x + DX[this.dir];
                int ny = this.y + DY[this.dir];

                if (isInRange(nx, ny)) {
                    changePosition(nx, ny);
                } else {
                    changeDir(this.dir);
                    nx = this.x + DX[this.dir];
                    ny = this.y + DY[this.dir];
                    changePosition(nx, ny);
                }
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

        @Override
        public int compareTo(Marble other) {
            if (this.speed != other.speed) {
                return other.speed - this.speed;
            }
            return other.number - this.number;
        }
    }
}