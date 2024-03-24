class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        boolean ab = a == b;
        boolean ac = a == c;
        boolean bc = b == c;
        if (ab && bc && ac) {
            answer += (a+b+c) * (Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2)) * (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3));
        } else if (ab || bc || ac) {
            answer += (a+b+c) * (Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2));
        } else {
            answer += (a+b+c);
        }
        return answer;
    }
}