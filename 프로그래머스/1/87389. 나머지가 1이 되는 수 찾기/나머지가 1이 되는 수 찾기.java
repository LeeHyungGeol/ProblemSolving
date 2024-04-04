import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(2,n).filter(i->n%i==1).findFirst().orElse(0);
    }
}