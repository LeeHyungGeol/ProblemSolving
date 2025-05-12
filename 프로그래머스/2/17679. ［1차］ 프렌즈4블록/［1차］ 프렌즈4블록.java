class Solution {
    private int[][] Board;
    private boolean[][] Check;
    private boolean nothingToRemove = true;
    private int answer = 0, M = 0, N = 0;
    
    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        Board = new int[M][N];
        Check = new boolean[M][N];
        
        initBoard(board);
        
        while (true) {
            nothingToRemove = true;
            
            checkIf4BlocksAreSame();
            removeBlocks();
            down();
            initCheck();
            
            if (nothingToRemove) {
                break;
            }
        }
        
        return answer;
    }
    
    private void checkIf4BlocksAreSame() {
        for (int i = 0; i < M-1; ++i) {
                for (int j = 0; j < N-1; ++j) {
                    if (Board[i][j] == 0) continue;
                    if (is4BlocksAreSame(i,j)) {
                        checkBlocks(i,j);
                    }
                }
            }
    }
    
    private void checkBlocks(int x, int y) {
        Check[x][y] = true;
        Check[x][y+1] = true;
        Check[x+1][y] = true;
        Check[x+1][y+1] = true;        
    }
    
    private void removeBlocks() {
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (Check[i][j]) {
                    Board[i][j] = 0;
                    nothingToRemove = false;
                    ++answer;
                }
            }
        }
    }
    
    private void down() {
        for (int col = 0; col < N; ++col) {
            gravity(col);
        }
    }
    
    private void gravity(int col) {
        int[] tempArr = new int[M];
        int endOfTempArr = M-1;
        
        for (int i = M-1; i >= 0; --i) {
            if (Board[i][col] != 0) {
                tempArr[endOfTempArr--] = Board[i][col];
            }
        }
        
        for (int i = M-1; i >= 0; --i) {
            Board[i][col] = tempArr[i];
        }
    }
    
    private void initCheck() {
        Check = new boolean[M][N];
    }
    
    private void initBoard(String[] board) {
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                char c = board[i].charAt(j);
                Board[i][j] = c-'A'+1;
            }
        }
    }
    
    private boolean is4BlocksAreSame(int x, int y) {
        return Board[x][y] == Board[x+1][y] && Board[x][y] == Board[x][y+1] && Board[x][y] == Board[x+1][y+1];
    }
}