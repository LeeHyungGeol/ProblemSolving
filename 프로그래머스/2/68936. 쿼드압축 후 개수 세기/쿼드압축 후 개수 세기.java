class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quadTree(arr, 0,0, arr.length);
        return answer;
    }
    
    private void quadTree(int[][] arr, int x, int y, int size) {
        if (isAllSameNumberInSquare(arr, x, y, arr[x][y], size)) {
            if (arr[x][y] == 0) {
                ++answer[0];
            } else {
                ++answer[1];
            }
            return;
        }
        quadTree(arr, x, y, size/2);
        quadTree(arr, x+(size/2), y, size/2);
        quadTree(arr, x, y+(size/2), size/2);
        quadTree(arr, x+(size/2), y+(size/2), size/2);
    }
    
    private boolean isAllSameNumberInSquare(int[][] arr, int x, int y, int value, int size) {
        for (int i = x; i < x+size; ++i) {
            for (int j = y; j < y+size; ++j) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}