class Solution {
    public int solution(int[][] dots) {
        double s1 = (double)(dots[1][1]-dots[0][1])/(dots[1][0]-dots[0][0]);
        double s2 = (double)(dots[3][1]-dots[2][1])/(dots[3][0]-dots[2][0]);
        
        double s3 = (double)(dots[3][1]-dots[0][1])/(dots[3][0]-dots[0][0]);
        double s4 = (double)(dots[2][1]-dots[1][1])/(dots[2][0]-dots[1][0]);
        
        double s5 = (double)(dots[2][1]-dots[0][1])/(dots[2][0]-dots[0][0]);
        double s6 = (double)(dots[3][1]-dots[1][1])/(dots[3][0]-dots[1][0]);
        
        
        return s1==s2 || s3==s4 || s5==s6 ? 1 : 0;
    }
}