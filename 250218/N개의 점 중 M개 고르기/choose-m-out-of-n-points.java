import java.util.*;

public class Main {
    static int N = 0, M = 0, Answer = Integer.MAX_VALUE;
    static boolean[] Selected;
    static Point[] Points;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        Points = new Point[N];
        Selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt(); 
            int y = scanner.nextInt();
            Points[i] = new Point(x,y);
        }

        Arrays.sort(Points);

        dfs(0,0);

        System.out.println(Answer);
    }

    private static void dfs(int start, int count) {
        if (count == M) {
            Answer = Math.min(Answer, calculate());
            return;
        }

        for (int i = start; i < N; ++i) {
            if (Selected[i]) continue;
            Selected[i] = true;
            dfs(i, count+1);
            Selected[i] = false;
        }
    }

    private static int calculate() {
        List<Point> selectedPoints = new ArrayList<>();
        int maxDistance = -1;

        for (int i = 0; i < N; ++i) {
            if (Selected[i]) {
                selectedPoints.add(Points[i]);
            }
        }

        for (int i = 0; i < selectedPoints.size(); ++i) {
            for (int j = i; j < selectedPoints.size(); ++j) {
                int curDistance = getDistance(selectedPoints.get(i), selectedPoints.get(j));
                maxDistance = Math.max(maxDistance, curDistance);
            }
        }

        return maxDistance;
    }

    private static int getDistance(Point p1, Point p2) {
        return (Math.abs(p1.x-p2.x)*Math.abs(p1.x-p2.x)) + (Math.abs(p1.y-p2.y)*Math.abs(p1.y-p2.y));
    }

    static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
    }    
}