class Solution {
    public int[][] solution(int[][] arr) {
        int N = arr.length > arr[0].length ? arr.length : arr[0].length;
        int[][] answer = new int[N][N];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i < arr.length && j < arr[i].length && arr[i][j] != 0)
                    answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}