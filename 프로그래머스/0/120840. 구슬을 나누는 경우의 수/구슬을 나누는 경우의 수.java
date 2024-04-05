import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        int denom = 1;
        for(int i = share+1; i <= balls; ++i){
            answer *= i;
            answer /= denom;
            ++denom;
        }
        
        return (int)answer;
    }
}