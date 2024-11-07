// bfs + 한번에 여러칸을 움직인다.
// 여러 칸을 움직여야 하기에 int[][] dist 와 같은 배열에 저장하기 애매하다?
import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] start = new int[2];
    static int[] goal = new int[2];
    static int N = 0, M = 0;
    
    static class Node {
        private int x;
        private int y;
        private int moving;
        
        public Node(int x, int y, int moving) {
            this.x = x;
            this.y = y;
            this.moving += moving;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getMoving() {
            return this.moving;
        }
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        findLocations(board);
        
        return bfs(board);
    }
    
    private int bfs(String[] board) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        
        visited[start[0]][start[1]] = true;
        q.add(new Node(start[0], start[1], 0));
        
        while (!q.isEmpty()) {
            Node cur = q.peek();
            q.poll();
            
            if (cur.getX() == goal[0] && cur.getY() == goal[1]) {
                return cur.getMoving();
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur.getX();
                int ny = cur.getY();
                
                while (inRange(nx, ny) && getCurrentChar(board, nx, ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, cur.getMoving() + 1));
                }
            }
        }
        
        return -1;
    }
    
    private boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
    
    private void findLocations(String[] board) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (getCurrentChar(board, i, j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                if (getCurrentChar(board, i, j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        } 
    }
    
    private char getCurrentChar(String[] board, int x, int y) {
        return board[x].charAt(y);
    }
}