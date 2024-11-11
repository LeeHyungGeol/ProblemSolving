import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static class Node {
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

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int index = 0;
        
        for (String[] place : places) {
            boolean flag = true;
            
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if (getCurrentChar(place, i, j) == 'P') {
                        if (!bfs(place, new Node(i,j))) {                    
                            flag = false;
                            break;
                        }
                    }
                }
            }
            
            answer[index++] = flag ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean bfs(String[] place, Node position) {
        boolean[][] visited = new boolean[place.length][place[0].length()];
        Queue<Node> q = new LinkedList<>();
        
        q.add(position);
        visited[position.getX()][position.getY()] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.peek();
            q.poll();
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];
                
                if (nx == position.getX() && ny == position.getY()) continue;
                if (inRange(nx, ny) && !visited[nx][ny] && getCurrentChar(place, nx, ny) != 'X' && getDistance(position, new Node(nx, ny)) <= 2) {   
                    if (getDistance(position, new Node(nx, ny)) <= 2 && getCurrentChar(place, nx, ny) == 'P') {
                        return false;
                    }
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        
        return true;
    }
    
    private int getDistance(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
    
    private boolean inRange(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5; 
    }
    
    private char getCurrentChar(String[] place, int x, int y) {
        return place[x].charAt(y);
    }
}