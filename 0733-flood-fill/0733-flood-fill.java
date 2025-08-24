class Solution {
    private static int M = 0;
    private static int N = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        M = image.length;
        N = image[0].length;
        boolean[][] visited = new boolean[M][N];
        int newColor = color;

        if (image[sr][sc] != newColor) {
            dfs(image, visited, sr, sc, image[sr][sc], newColor);
        }

        return image;
    }

    private void dfs(int[][] image, boolean[][] visited, int x, int y, int color, int newColor) {
        visited[x][y] = true;
        image[x][y] = newColor;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (!visited[nx][ny] && image[nx][ny] == color) {
                image[nx][ny] = newColor;
                dfs(image, visited, nx, ny, color, newColor);
            }
        }
    }
}