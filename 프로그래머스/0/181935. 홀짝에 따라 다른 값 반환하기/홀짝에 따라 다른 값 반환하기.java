class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean flag = n % 2 == 0 ? true : false;
        while(n > 0) {
            answer = flag ? answer + (n*n) : answer + n;
            n -= 2;
        }
        return answer;
    }
}