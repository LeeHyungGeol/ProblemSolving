import java.util.*;

class Solution {
    private static int[] Dx = {-1,1,0,0};
    private static int[] Dy = {0,0,-1,1};
    private static int[][] Map = new int[101][101];
    private static boolean[][] Visited = new boolean[101][101];
    
    static class Node {
        private int x;
        private int y;
        private int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getDist() {
            return this.dist;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) { 
        fillRectangle(rectangle);
        
        return bfs(rectangle, 2*characterX, 2*characterY, 2*itemX, 2*itemY);
    }
    
    private int bfs(int[][] rectangle, int startX, int startY, int endX, int endY) {
        int result = (int) 1e9;
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(startX, startY, 0));
        Visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if (isEndPoint(node, endX, endY)) {
                result = Math.min(result, node.getDist()/2);
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = node.getX() + Dx[i];
                int ny = node.getY() + Dy[i];
                
                if (!isInRange(nx, ny)) continue;
                if (Visited[nx][ny]) continue;
                if (Map[nx][ny] == 1) {
                    Visited[nx][ny] = true;
                    q.add(new Node(nx, ny, node.getDist()+1));
                }
            }
        }
        
        return result;
    }
    
    private boolean isInRange(int x, int y) {
        return 0 <= x && x <= 100 && 0 <= y && y <= 100;
    }
    
    private boolean isEndPoint(Node point, int endX, int endY) {
        return point.getX() == endX && point.getY() == endY;
    }
    
    
    private void fillRectangle(int[][] rectangle) {
        for (int[] point : rectangle) {
            int leftX = 2*point[0];
            int leftY = 2*point[1];
            int rightX = 2*point[2];
            int rightY = 2*point[3];
            
            for (int i = leftX; i <= rightX; ++i) {
                for (int j = leftY; j <= rightY; ++j) {
                    if (Map[i][j] == 2) continue;
                    Map[i][j] = 2;
                    if (i == leftX || i == rightX || j == leftY || j == rightY) {
                        Map[i][j] = 1;
                    }
                }
            }
        }
        
        return;
    }
}