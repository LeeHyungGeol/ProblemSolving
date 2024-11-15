import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        if (p.isEmpty()) {
            return "";
        }
        
        int index = splitToBalancedString(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);
        
        if (isProper(u)) {
            return u+solution(v);
        } else {
            answer = '(' + solution(v) + ')';
            u = u.substring(1, u.length() - 1);
            
            String temp = "";
            for(int i = 0; i < u.length(); ++i) {
                if(u.charAt(i) == '(') {
                    temp += ')';
                }
                else {
                    temp += '(';
                }
            }
            
            answer += temp;
            return answer;
        }
    }
    
    private int splitToBalancedString(String w) {
        int count = 0, index = 0;
        
        for (int i = 0; i < w.length(); ++i) {
            if (w.charAt(i) == '(') {
                ++count;
            }
            else {
                --count;
            }
            if (count == 0) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    private boolean isProper(String w) {
        int count = 0;
        
        for (int i = 0; i < w.length(); ++i) {
            if (w.charAt(i) == '(') {
                ++count;
            }
            else {
                --count;
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}