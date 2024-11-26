import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int size = 1; size <= s.length()/2; ++size) {
            String result = "";
            String w = s.substring(0, size);
            int count = 0;
            
            for (int i = 0; i < s.length(); i+=size) {
                int endIndex = i+size;
                if (endIndex > s.length()) endIndex = s.length();
                String m = s.substring(i, endIndex);
                if (w.equals(m)) {
                    ++count;
                } else {
                    if (count > 1) {
                        result += count + w;                         
                    } else {
                        result += w;
                    }
                    count = 1;
                    w = m;
                }
            }
            
            if (count > 1) {
                result += count + w;                         
            } else {
                result += w;
            }
                        
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}