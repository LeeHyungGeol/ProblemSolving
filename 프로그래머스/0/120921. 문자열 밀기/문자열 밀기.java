import java.util.Arrays;

class Solution {
    public int solution(String A, String B) {
        // return (B+B).indexOf(A);
        String tmp = A;
        for (int i = 0; i < A.length(); ++i) {
            if (tmp.equals(B)) return i;
            tmp = tmp.charAt(A.length()-1) + tmp.substring(0, A.length()-1);
        }
        
        return -1;
    }
}