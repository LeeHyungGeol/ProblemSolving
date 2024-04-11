class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0, width = board[0]/2, height = board[1]/2;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        String[] moves = {"up", "down", "left", "right"};
        
        for (String input : keyinput) {
            for (int i = 0; i < moves.length; ++i) {
                if (input.equals(moves[i])) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (ny < -height || ny > height || nx < -width || nx > width) continue;
                    x = nx;
                    y = ny;
                }
            }
        }
        return new int[]{x,y};
    }
}