// Integer.toString(n, k);
// Integer.parseInt("1234567", k);

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String integerToString = Integer.toString(n,k);
    
        for (String s : integerToString.split("0")) {
            if (s.equals("")) continue;
            long l = Long.parseLong(s);
            if (isPrime(l)) ++answer;
        }
        
        return answer;
    }
    
    public boolean isPrime (long a){
        if (a < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(a); ++i){
            if(a%i == 0) {
                return false;
            }
        }
        return true;
    }
}