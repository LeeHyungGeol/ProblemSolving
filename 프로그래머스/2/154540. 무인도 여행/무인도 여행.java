// Connected Components + bfs(간선 간의 weight 가 같기 때문에)

import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N = 0, M = 0;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (getCurrentChar(maps, i, j) != 'X' && !visited[i][j]) {
                    answer.add(bfs(maps, visited, i, j));
                }
            }
        }
        
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(String[] maps, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        
        result += Integer.parseInt(Character.toString(getCurrentChar(maps, x, y)));
        q.add(new int[]{x,y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.peek();
            q.poll();
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (getCurrentChar(maps, nx, ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        result += Integer.parseInt(Character.toString(getCurrentChar(maps, nx, ny)));
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return result;
    }
    
    private char getCurrentChar(String[] maps, int x, int y) {
        return maps[x].charAt(y);
    }
}