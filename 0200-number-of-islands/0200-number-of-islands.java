class Solution {
    public int numIslands(char[][] grid) {
        return dfsAll(grid);
    }

    private int dfsAll(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j, m, n);
                    ++count;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y, int m, int n) {
        visited[x][y] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (!visited[nx][ny] && grid[nx][ny] == '1') {
                dfs(grid, visited, nx, ny, m, n);
            }
        }
    }
}