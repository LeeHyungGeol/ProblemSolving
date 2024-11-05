import java.util.*;

class Solution {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int answer = 0, N = 0, M = 0;
    private static int[] start = new int[2];
    private static int[] lever = new int[2];
    private static int[] exit = new int[2];
    
    public int solution(String[] maps) {
        N = maps.length; 
        M = maps[0].length();
        
        findLocations(maps);
        bfs(maps);
        
        return answer;
    }
        
    private void bfs(String[] maps) {
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(start);
        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.peek();
            q.poll();
            
            if (getCurrentChar(maps, cur[0], cur[1]) == 'L') {
                break;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (getCurrentChar(maps, nx, ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        if (dist[lever[0]][lever[1]] == 0) {
            answer = -1;
            return;
        }
        answer += dist[lever[0]][lever[1]];
        
        
        dist = new int[N][M];
        visited = new boolean[N][M];    
        q = new LinkedList<>();
        
        q.add(lever);
        visited[lever[0]][lever[1]] = true;
        dist[lever[0]][lever[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.peek();
            q.poll();
            
            if (getCurrentChar(maps, cur[0], cur[1]) == 'E') {
                break;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (getCurrentChar(maps, nx, ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        if (dist[exit[0]][exit[1]] == 0) {
            answer = -1;
            return;
        } 
        answer += dist[exit[0]][exit[1]];
        
        return;
    }
    
    private char getCurrentChar(String[] maps, int x, int y) {
        return maps[x].charAt(y);
    }
    
    private void findLocations(String[] maps) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
                if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
    }
}