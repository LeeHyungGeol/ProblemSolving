import static java.lang.Math.max;

class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int n = triangle.length;
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < triangle[i].length; ++j) {
                int left, right;
                
                if(j-1 < 0) {
                    left = 0;
                }
                else {
                    left = triangle[i-1][j-1];
                }
                if(i-1 < j) {
                    right = 0;
                }
                else {
                    right = triangle[i-1][j];
                }
                
                triangle[i][j] = triangle[i][j] + max(left, right);
            }
        }
        
        for(int i = 0; i < n; ++i) {
            answer = max(answer, triangle[n-1][i]);
        }
        
        return answer;
    }
}