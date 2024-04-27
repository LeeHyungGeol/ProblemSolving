class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0, painted = 0;
        
        for (int notPainted : section) {
            if (painted > notPainted) continue;
            painted = notPainted + m;
            ++answer;
        }
        
        return answer;
    }
}