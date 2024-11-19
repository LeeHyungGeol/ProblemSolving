import java.util.*;

class Solution {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int index = 0;
        
        init(matrix);
        
        for (int[] query : queries) {
            X1 = query[0]-1;
            Y1 = query[1]-1;
            X2 = query[2]-1;
            Y2 = query[3]-1;
            
            int Min = (int) 1e9;
            int direction = 0;
            int x = query[0]-1, y = query[1]-1, temp = matrix[x][y];
            Min = Math.min(Min, matrix[x][y]);
            
            while (true) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                
                Min = Math.min(Min, matrix[nx][ny]);
                int swapTemp = matrix[nx][ny];
                matrix[nx][ny] = temp;
                temp = swapTemp;
                
                x = nx;
                y = ny;
                
                direction = turn(x, y, direction);
                
                if (x == X1 && y == Y1) {
                    break;
                }
            }
            
            answer[index++] = Min;
        }
        
        return answer;
    }
    
    private int turn(int x, int y, int direction) {
        if(x == X1 && y == Y2) {
            direction = 1;
        }
        else if(x == X2 && y == Y2) {
            direction = 2;
        }
        else if(x == X2 && y == Y1) {
            direction = 3;
        }
        return direction;
    }
    
    private void init(int[][] matrix) {
        int n = 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[i][j] = n++;
            }
        }
        return;
    }
    
    
}