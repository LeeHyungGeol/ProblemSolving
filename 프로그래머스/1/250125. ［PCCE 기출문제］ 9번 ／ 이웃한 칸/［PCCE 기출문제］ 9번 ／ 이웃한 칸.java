class Solution {
    private static int[] dh = {1,-1,0,0};
    private static int[] dw = {0,0,1,-1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];

        for (int i = 0; i < 4; ++i) {
            int x = h + dh[i];
            int y = w + dw[i];
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if (color.equals(board[x][y])) ++answer;
        }
        
        return answer;
    }
}