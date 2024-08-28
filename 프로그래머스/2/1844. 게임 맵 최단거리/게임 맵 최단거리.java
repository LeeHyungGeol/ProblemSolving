import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(0,0, maps);
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] d = new int[n][m];     
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x,y));
        visited[x][y] = true;
        d[x][y] = 1;
        
        while(!q.isEmpty()) {
            int curX = q.peek().getX();
            int curY = q.peek().getY();
            
            q.poll();
            
            for(int i = 0; i < 4; ++i) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        d[nx][ny] = d[curX][curY] + 1;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
        
        if(d[n-1][m-1] == 0) {
            return -1;
        }
        else {
            return d[n-1][m-1];
        }
    }
}

class Node {
    private int x;
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}