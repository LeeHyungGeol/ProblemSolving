import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(4,n).filter(i-> IntStream.range(2,i).anyMatch(x->i%x==0)).count();
    }
}