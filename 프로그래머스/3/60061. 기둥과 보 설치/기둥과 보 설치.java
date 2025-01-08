import java.util.*;

class Solution {
    
    private static int[][] Columns;
    private static int[][] Rows;
    private static int N = 0;
        
    public int[][] solution(int n, int[][] build_frame) {
        Columns = new int[n+1][n+1];
        Rows = new int[n+1][n+1];
        N = n;
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];
            
            if (a == 0) {
                if (b == 1 && canExistColumn(x,y)) {
                    Columns[x][y] = 1;
                } else {
                    Columns[x][y] = 0;
                    if (canDestroy(x,y) == false) {
                        Columns[x][y] = 1;
                    }
                }
            } else {
                if (b == 1 && canExistRow(x,y)) {
                    Rows[x][y] = 1;
                } else {
                    Rows[x][y] = 0;
                    if (canDestroy(x,y) == false) {
                        Rows[x][y] = 1;
                    }
                }
            }
        }
        
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= N; ++j) {
                if (Columns[i][j] == 1) {
                    answer.add(new int[]{i,j,0});
                }
                if (Rows[i][j] == 1) {
                    answer.add(new int[]{i,j,1});
                }
            }
        }
        
        return answer.toArray(new int[0][]);
    }
    
    private boolean canExistColumn(int x, int y) {
        if (y == 0) {
            return true;
        } else if (inRange(x,y-1) && Columns[x][y-1] == 1) {
            return true;
        } else if ((inRange(x-1,y) && Rows[x-1][y] == 1) || Rows[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean canExistRow(int x, int y) {
        if ((inRange(x,y-1) && Columns[x][y-1] == 1) || (inRange(x+1,y-1) && Columns[x+1][y-1] == 1)) {
            return true;
        } else if ((inRange(x-1,y) && Rows[x-1][y] == 1) && (inRange(x+1,y) && Rows[x+1][y] == 1)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean canDestroy(int x, int y) {
        for (int i = x-1; i <= x+1; ++i) {
            for (int j = y; j <= y+1; ++j) {
                if (inRange(i,j)) {
                    if (Columns[i][j] == 1 && canExistColumn(i,j) == false) {
                        return false;
                    }
                    if (Rows[i][j] == 1 && canExistRow(i,j) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean inRange(int x, int y) {
        return 0 <= x && x <= N && 0 <= y && y <= N;
    }
}