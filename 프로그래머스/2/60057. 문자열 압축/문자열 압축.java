import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        
        for (int len = 1; len <= length/2; ++len) {
            int count = 0;
            String a = s.substring(0, len);
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i <= length; i += len) {
                String b = s.substring(i, Math.min(length, i+len));
                
                if (a.equals(b)) {
                    ++count;
                } else {
                    if (count > 1) {
                        sb.append(count).append(a);
                    } else {
                        sb.append(a);
                    }
                    count = 1;
                    a = b;
                }
            }
            if (count > 1) {
                sb.append(count).append(a);
            } else {
                sb.append(a);
            }
            
            answer = Math.min(sb.length(), answer);
        }
        
        return answer;
    }
}