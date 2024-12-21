class Solution {
    public long solution(int[] sequence) {
        long answer = 0, p1 = 0, p2 = 0;
        boolean isPlus = true;
        
        for (int s : sequence) {
            p1 += isPlus ? s : -s;
            p2 += isPlus ? -s : s;
            
            p1 = Math.max(0, p1);
            p2 = Math.max(0, p2);
            
            answer = Math.max(answer, Math.max(p1,p2));
            
            isPlus = !isPlus;
        }
        
        return answer;
    }
}