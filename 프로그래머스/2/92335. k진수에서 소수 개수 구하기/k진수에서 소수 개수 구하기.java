// Integer.toString(n, k);
// Integer.parseInt("1234567", k);

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n,k).split("0");
    
        for (String s : arr) {
            if (s.equals("")) continue;
            long l = Long.parseLong(s);
            if (isPrime(l)) ++answer;
        }
        
        return answer;
    }
    
    public boolean isPrime (long l){
        if (l < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(l); ++i){
            if(l%i == 0) {
                return false;
            }
        }
        return true;
    }
}