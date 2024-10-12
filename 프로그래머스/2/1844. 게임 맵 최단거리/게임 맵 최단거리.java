import java.util.*;

class Solution {
    public static final int[] DIRECTION_X = {-1,1,0,0};
    public static final int[] DIRECTION_Y = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        arr[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int currentX = queue.peek()[0];
            int currentY = queue.peek()[1];
                    
            queue.poll();
            
            for (int i = 0; i < 4; ++i) {
                int newX = currentX + DIRECTION_X[i];
                int newY = currentY + DIRECTION_Y[i];
                
                if (0 <= newX && newX < n && 0 <= newY && newY < m) {
                   if (maps[newX][newY] == 1 && !visited[newX][newY]) {    
                        visited[newX][newY] = true;
                        arr[newX][newY] = arr[currentX][currentY] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        
        if (arr[n-1][m-1] == 0) {
            return -1;
        }
        
        return arr[n-1][m-1];
    } 
}