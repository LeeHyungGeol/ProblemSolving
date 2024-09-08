class Solution {
    public String solution(String p) {
        String answer = "";
        
        if(p.length() == 0) {
            return answer;
        }
        
        int index = isBalanced(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        
        if(isProper(u)) {
            return u + solution(v);
        }
        else {
            answer += '(';
            answer += solution(v);
            answer += ')';
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
    
    public int isBalanced(String str) {
        int cnt = 0;
        
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == '(') {
                ++cnt;
            }
            else {
                --cnt;
            }
            if(cnt == 0) {
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean isProper(String str) {
        int cnt = 0;
        
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == '(') {
                ++cnt;
            }
            else {
                --cnt;
                if(cnt == 0) {
                    return true;
                }
            }        
        }
        
        return false;
    }
}