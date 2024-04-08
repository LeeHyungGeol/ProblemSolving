class Solution {
    public int[][] solution(int n) {
//         int[][] answer = new int[n][n];
//         int row = 0, col = 0, value = 1, direction = 0;
        
//         while(value <= n*n) {
//             answer[row][col] = value++;
            
//             if (direction == 0) {
//                 if (col == n-1 || answer[row][col+1] != 0) {
//                     direction = 1;
//                     ++row;
//                 }
//                 else ++col;
//             }
//             else if (direction == 1) {
//                 if (row == n-1 || answer[row+1][col] != 0) {
//                     direction = 2;
//                     --col;
//                 }
//                 else ++row;
//             }
//             else if (direction == 2) {
//                 if (col == 0 || answer[row][col-1] != 0) {
//                     direction = 3;
//                     --row;
//                 }
//                 else --col;
//             }
//             else if (direction == 3) {
//                 if (row == 0 || answer[row-1][col] != 0) {
//                     direction = 0;
//                     ++col;
//                 }
//                 else --row;
//             }
//         }
        
//         return answer;
        
        int[][] answer = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int direction = 0;

        while (num <= n * n) {
            answer[x][y] = num++;

            int nx = x + dx[direction]; 
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                direction = (direction + 1) % 4; //범위 밖에 나갔을 때 방향전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
}