import java.util.*;
import java.io.*;

public class Main {
    private static final Point IllegalPoint = new Point(-1, -1);

    private static int N = 0, M = 0;
    private static ArrayDeque<Integer>[][] Arr;
    private static int[] DX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] DY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Arr = new ArrayDeque[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Arr[i][j] = new ArrayDeque<>();
            }
        }
            
        for(int i = 0; i < N; i++)  {
            for(int j = 0; j < N; j++) {
                int num = sc.nextInt(); 
                Arr[i][j].add(num);
            }
        }

        for (int i  = 0; i < M; ++i) {
            int value = sc.nextInt();

            simulate(value);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Arr[i][j].isEmpty()) {
                    System.out.print("None");
                } else {
                    for (int v : Arr[i][j]) {
                        System.out.print(v + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void simulate(int value) {
        Point curPoint = findNum(value);
        Point nextPoint = findMax(curPoint);
        if (nextPoint != IllegalPoint) {
            move(value, curPoint, nextPoint);
        }
    }

    private static Point findNum(int value) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int num : Arr[i][j]) {
                    if (num == value) {
                        return new Point(i, j);
                    }
                }
            }
        }

        return IllegalPoint;
    }

    private static Point findMax(Point p) {
        Point result = IllegalPoint;
        int max = -1;

        for (int d = 0; d < 8; ++d) {
            int nx = p.x + DX[d];
            int ny = p.y + DY[d];

            if (!isInRange(nx, ny)) continue;
            if (Arr[nx][ny].isEmpty()) continue;
            for (int num : Arr[nx][ny]) {
                if (num > max) {
                    max = num;
                    result = new Point(nx, ny);
                }
            }
        }

        return result;
    }

    private static void move(int value, Point curPoint, Point nextPoint) {
        boolean isToMove = false;

        Iterator<Integer> it = Arr[curPoint.x][curPoint.y].descendingIterator();
		while(it.hasNext()){
			int k = it.next();
			if (value == k) {
                isToMove = true;
            }
			if(isToMove){
				Arr[nextPoint.x][nextPoint.y].offerFirst(k);
				it.remove();
			}
		}
    }
    

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}