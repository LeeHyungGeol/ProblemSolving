import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int cnt = 0;
        
        Arrays.sort(citations);
        
        for (int h = 1; h <= citations.length; ++h) {
            for (int i = 0; i < citations.length; ++i) {
                if (h <= citations[i]) {
                    ++cnt;
                }
            }
            
            if (h <= cnt && citations.length-cnt <= h) {
                answer = h;
            }
            
            cnt = 0;
        }
        
        return answer;
    }
}