import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];
		int maxHeight = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
				maxHeight = Math.max(maxHeight, matrix[i][j]);
			}
		}

		int maxSafetyZone = 0;
		for (int limit = 0; limit <= maxHeight; ++limit) {
			maxSafetyZone = Math.max(maxSafetyZone, dfsAll(matrix, n, limit));
		}

		System.out.println(maxSafetyZone);
	}

	private static int dfsAll(int [][] matrix, int n, int limit) {
		boolean[][] visited = new boolean[n][n];
		int count = 0;

		for (int x = 0; x < n; ++x) {
			for (int y = 0; y < n; ++y) {
				if (matrix[x][y] > limit && !visited[x][y]) {
					dfs(matrix, visited, n, x, y, limit);
					++count;
				}
			}
		}

		return count;
	}

	private static void dfs(int[][] matrix, boolean[][] visited, int n, int x, int y, int limit) {
		visited[x][y] = true;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if (matrix[nx][ny] > limit && !visited[nx][ny]) {
				dfs(matrix, visited, n, nx, ny, limit);
			}
		}
	}
}
