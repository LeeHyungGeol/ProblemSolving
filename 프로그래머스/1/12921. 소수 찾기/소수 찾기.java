import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(2,n).filter(N->{
            for (int i=2; i*i <= N; ++i) {
                if(N%i==0) 
                    return false;
            }
            return true;
        }).count();
    }
}