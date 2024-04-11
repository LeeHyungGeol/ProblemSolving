import java.util.*;

class Solution {
    class Point {
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        List<Point> list = new ArrayList<>();
        
        // List<int[]> al = new ArrayList<>();
        // al.add(new int[]{i, j});
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (board[i][j] == 1) 
                    list.add(new Point(i,j));
            }
        }
        
        for (Point p : list) {
            for (int k = 0; k < 8; ++k) {
                int nx = p.getX() + dx[k];
                int ny = p.getY() + dy[k];
                        
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) continue;
                board[nx][ny] = 1;
            }
        }
        
        return (int) Arrays.stream(board).flatMapToInt(Arrays::stream).filter(i->i!=1).count();
    }
}