class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h - (long)(w+h - gcd(w,h));
        return answer;
    }
    
    public long gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a%b);
    }
    
    
}