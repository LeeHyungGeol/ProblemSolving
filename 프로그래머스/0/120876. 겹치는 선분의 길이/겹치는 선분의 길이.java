class Solution {
    public int solution(int[][] lines) {
        int[] dots = new int[201];
        int answer = 0;
        
        for (int[] l : lines) {
            int s = l[0]+100;
            int e = l[1]+100;
            
            for (int i = s; i < e; ++i) {
                ++dots[i];
            }
        }
        
        for (int d : dots) {
            if (d>1) ++answer;
        }
        
        return answer;
    }
}