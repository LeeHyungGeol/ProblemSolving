class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        map[0][0] = 1;
        
        for (int[] point : puddles) {
            map[point[1]-1][point[0]-1] = -1;
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int up = 0, left = 0;
                if (i-1 < 0 || map[i-1][j] == -1) {
                    up = 0;
                } else {
                    up = map[i-1][j];
                }
                if (j-1 < 0 || map[i][j-1] == -1) {
                    left = 0;
                } else {
                    left = map[i][j-1];
                }
                if (map[i][j] != -1) {
                    map[i][j] += (left + up)%1000000007;
                }
            }
        }
        
        return map[n-1][m-1]%1000000007;
    }
}