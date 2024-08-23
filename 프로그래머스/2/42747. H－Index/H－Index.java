import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length, cnt = 0;
        
        Arrays.sort(citations);
        
        for(int h = 1; h <= n; ++h) {
            for(int i = 0; i < n; ++i) {
                if(h <= citations[i]) {
                    ++cnt;
                }
            }
            
            if(h <= cnt && n-cnt <= h) {
                answer = h;
            }
            
            cnt = 0;
        }
        
        return answer;
    }
}