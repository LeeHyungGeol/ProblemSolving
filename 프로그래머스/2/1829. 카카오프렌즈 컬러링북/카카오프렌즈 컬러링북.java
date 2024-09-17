import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        List<Integer> answers = dfsAll(picture);
        
        int numberOfArea = answers.get(0);
        int maxSizeOfOneArea = answers.get(1);

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public List<Integer> dfsAll(int[][] picture) {
        visited = new boolean[100][100];
        List<Integer> answers = new ArrayList<>();
        int components = 0;
        int maxConnectedNodes = 0;
        
        for(int i = 0; i < picture.length; ++i) {
            for(int j = 0; j < picture[0].length; ++j) {
                if(!visited[i][j] && picture[i][j] > 0) {
                    int nodes = dfs(i, j, picture);
                    ++components;
                    maxConnectedNodes = Math.max(maxConnectedNodes, nodes);
                }
            }
        }
        
        answers.add(components);
        answers.add(maxConnectedNodes);
        
        return answers;
    }
    
    public int dfs(int x, int y, int[][] picture) {
        visited[x][y] = true;
        
        int nodes = 1;
        
        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(0 <= nx && nx < picture.length && 0 <= ny && ny < picture[0].length) {
                if(!visited[nx][ny] && picture[x][y] == picture[nx][ny]) {
                    nodes += dfs(nx, ny, picture);
                }
            }
        }
        
        return nodes;
    }
}