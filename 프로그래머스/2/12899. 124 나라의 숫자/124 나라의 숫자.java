class Solution {
    public String solution(int n) {
        String answer = "";
        
        while (n > 0) {
            int temp = n % 3;
            
            if(temp == 0) {
                answer = "4" + answer;
                n = n / 3 - 1;
            }
            else {
                answer = Integer.toString(n%3) + answer;
                n /= 3;
            }
        }
    
        return answer;
    }
}