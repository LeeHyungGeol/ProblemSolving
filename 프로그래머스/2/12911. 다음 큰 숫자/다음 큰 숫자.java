class Solution {
    public int solution(int n) {
        int answer = n;
        int nOneCnt = Integer.toBinaryString(n).replace("0", "").length();
        
        while (true) {
            ++answer;
            if (nOneCnt == Integer.toBinaryString(answer).replace("0", "").length()) break;
        }
        
        return answer;
    }
}