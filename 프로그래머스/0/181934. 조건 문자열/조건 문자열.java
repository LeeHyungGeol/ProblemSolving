class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String conditional = ineq+eq;
        
        if (conditional.equals(">=")) {
            answer = n >= m ? 1 : 0;
        } else if (conditional.equals("<=")) {
            answer = n <= m ? 1 : 0;
        } else if (conditional.equals(">!")) {
            answer = n > m ? 1 : 0;
        } else if (conditional.equals("<!")) {
            answer = n < m ? 1 : 0;
        } 
        return answer;
    }
}