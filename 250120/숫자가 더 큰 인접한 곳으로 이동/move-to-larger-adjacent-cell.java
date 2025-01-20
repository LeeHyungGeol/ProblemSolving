import java.util.*;

public class Main {
	private static int N = 0;
	private static int[] DX = {-1,1,0,0};
	private static int[] DY = {0,0,-1,1};

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
		int x = r;
		int y = c;
		List<Integer> answer = new ArrayList<>();
		answer.add(arr[x][y]);

		while(true) {
			boolean greaterNumberExist = false;

			for (int d = 0; d < 4; ++d) {
				int nx = x + DX[d];
				int ny = y + DY[d];

				if (isInRange(nx, ny) && arr[nx][ny] > arr[x][y]) {
					answer.add(arr[nx][ny]);
					x = nx;
					y = ny;
					greaterNumberExist = true;
					break;
				}
			}

			if (!greaterNumberExist) {
				break;
			}
		}

		for (int num : answer) {
			System.out.print(num + " ");
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
