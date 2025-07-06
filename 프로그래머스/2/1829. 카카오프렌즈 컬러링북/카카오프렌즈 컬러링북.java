import java.util.*;

class Solution {
    private  boolean[][] Visited;
    private  int[] Dx = {-1,1,0,0};
    private  int[] Dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        List<Integer> answer = dfsAll(m,n,picture);
        
        return new int[]{answer.get(0), answer.get(1)};
    }
    
    private List<Integer> dfsAll(int m, int n, int[][] picture) {
        Visited = new boolean[100][100];
        List<Integer> answer = new ArrayList<>();
        int components = 0;
        int maxConnectedComponents = 0;
        
        for(int i = 0; i < picture.length; ++i) {
            for(int j = 0; j < picture[0].length; ++j) {
                if(!Visited[i][j] && picture[i][j] > 0) {
                    int count = dfs(i, j, picture);
                    ++components;
                    maxConnectedComponents = Math.max(maxConnectedComponents, count);
                }
            }
        }
        
        answer.add(components);
        answer.add(maxConnectedComponents);
        return answer;
    }
    
    private int dfs(int x, int y, int[][] picture) {
        Visited[x][y] = true;
        int count = 1;
        
        for(int i = 0; i < 4; ++i) {
            int nx = x + Dx[i];
            int ny = y + Dy[i];
            
            if(0 <= nx && nx < picture.length && 0 <= ny && ny < picture[0].length) {
                if(!Visited[nx][ny] && picture[x][y] == picture[nx][ny]) {
                    count += dfs(nx, ny, picture);
                }
            }
        }
        
        return count;
    }
}