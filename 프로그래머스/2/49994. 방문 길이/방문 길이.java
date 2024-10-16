// 반대 방향으로 오는 것도 확인하자.
// 범위 바깥이면 바로 continue 처리하자.

import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    Map<String, Integer> directionGuide = new HashMap<>(){{
       put("U", 0);
       put("D", 1); 
       put("R", 2); 
       put("L", 3); 
    }};
    Map<Integer, Integer> opposite = new HashMap<>(){{
        put(0,1);
        put(1,0);
        put(2,3);
        put(3,2);
    }};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int[] current = {5,5};
        
        for (String direction : dirs.split("")) {
            int d = directionGuide.get(direction);
            int newX = current[0] + dx[d];
            int newY = current[1] + dy[d];
            
            if (!isInBoundary(newX, newY)) continue;  
            if (!visited[newX][newY][d]) {
                visited[newX][newY][d] = true;
                visited[current[0]][current[1]][opposite.get(d)] = true;
                ++answer;
            }
            current = new int[]{newX, newY};

        }
        
        return answer;
    }
    
    private boolean isInBoundary(int x, int y) {
        return (0 <= x && x <= 10 && 0 <= y && y <= 10);
    }
}