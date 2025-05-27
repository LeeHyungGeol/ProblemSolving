class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int lockLength = lock.length;
        int keyLength = key.length;
        int[][] newLock = new int[lockLength*3][lockLength*3];
        
        for (int i = 0; i < lockLength; ++i) {
            for (int j = 0; j < lockLength; ++j) {
                newLock[lockLength+i][lockLength+j] = lock[i][j];
            }
        }
        
        for (int rotate = 0; rotate < 4; ++rotate) {
            key = rotate90Clockwise(key);
            
            for (int x = 0; x < lockLength*2; ++x) {
                for (int y = 0; y < lockLength*2; ++y) {
                    
                    for (int i = 0; i < keyLength; ++i) {
                        for (int j = 0; j < keyLength; ++j) {
                            newLock[x+i][y+j] += key[i][j];
                        }
                    }
                    
                    if (check(newLock)) {
                        return true;
                    }
                    
                    for (int i = 0; i < keyLength; ++i) {
                        for (int j = 0; j < keyLength; ++j) {
                            newLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private int[][] rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[0][0];
        
        int m = matrix[0].length;
        int[][] rotated = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
    
        return rotated;
    }
    
    private boolean check(int[][] matrix) {
        int lockLength = matrix.length / 3;
        
        for (int i = lockLength; i < lockLength*2; ++i) {
            for (int j = lockLength; j < lockLength*2; ++j) {
                if (matrix[i][j] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}