import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);
        
        StringBuffer sb = new StringBuffer();
        for (String s : list) sb.append(s);
        
        return Long.parseLong(sb.reverse().toString());
    }
}