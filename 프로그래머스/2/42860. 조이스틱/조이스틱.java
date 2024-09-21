class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int step = n - 1;
        
        for(int i = 0; i < n; ++i) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            
            int left = i;
            int right = i + 1;
            
            while(right < n && name.charAt(right) == 'A') {
                ++right;
            }
            
            step = Math.min(step, left + n - right + Math.min(left, n-right));
        }
        
        answer += step;
        
        return answer;
    }
}