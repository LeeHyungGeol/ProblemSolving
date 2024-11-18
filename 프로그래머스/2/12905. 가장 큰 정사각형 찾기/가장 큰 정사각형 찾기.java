import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int answer = board[0][0];
        int[][] dp = new int[board.length][board[0].length];
        
        for (int i = 1; i < board.length; ++i) {
            for (int j = 1; j < board[i].length; ++j) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    answer = Math.max(board[i][j], answer);
                }
            } 
        }

        
        return answer*answer;
    }
}