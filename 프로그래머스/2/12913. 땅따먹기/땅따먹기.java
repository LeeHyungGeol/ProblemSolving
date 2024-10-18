// 완전 탐색
// 인 줄 알았는데, N 이 100_000 이어서 시간 초과가 난다.
// dp 문제
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i < land.length; ++i) {
            land[i][0] += maxNumber(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += maxNumber(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += maxNumber(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += maxNumber(land[i-1][0], land[i-1][1], land[i-1][2]);
        }
        
        for (int i = 0; i < 4; ++i) {
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
    
    private int maxNumber(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }
}