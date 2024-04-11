import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
                        .map(i -> (int)IntStream.rangeClosed(1,i).filter(n->i%n==0).count() % 2 == 0 ? i : -i)
                        .sum();
    }
}