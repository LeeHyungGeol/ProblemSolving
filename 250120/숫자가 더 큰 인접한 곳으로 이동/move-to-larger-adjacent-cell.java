import java.util.*;

public class Main {
	private static int N = 0;
	private static int[] DX = {0,0,-1,1};
	private static int[] DY = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		sc.close();

		N = n;

		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> o2.direction - o1.direction);
		pq.add(new Point(r,c, -1, arr[r][c]));


		while(true) {
			boolean isBiggerThan = false;
			Point maxPoint = pq.poll();
			pq.clear();

			System.out.print(maxPoint.num + " ");

			int x = maxPoint.x;
			int y = maxPoint.y;

			for (int d = 0; d < 4; ++d) {
				int nx = x + DX[d];
				int ny = y + DY[d];

				if (isInRange(nx, ny) && arr[nx][ny] > maxPoint.num) {
					pq.add(new Point(nx, ny, d, arr[nx][ny]));
					isBiggerThan = true;
				}
			}

			if (!isBiggerThan) {
				break;
			}
		}
	}

	private static boolean isInRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static class Point {
		 int x;
		 int y;
		 int direction;
		 int num;

		public Point(int x, int y, int direction, int num) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.num = num;
		}
	}
}
